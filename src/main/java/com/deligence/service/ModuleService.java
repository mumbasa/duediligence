package com.deligence.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.deligence.models.Index;
import com.deligence.models.Module;
import com.deligence.models.Section;
import com.deligence.repository.IndexRepository;
import com.deligence.repository.ModuleRepository;

@Service
public class ModuleService {

	@Autowired
	ModuleRepository moduleRepository;

	@Autowired
	IndexRepository indexRepository;

	@Autowired
	SectionService sectionService;

	@Autowired
	JdbcTemplate template;

	public Module saveModule(Module module) {
		return moduleRepository.save(module);

	}

	public List<Module> getModules() {
		List<Module> modules = moduleRepository.findAll();
		return modules;

	}
	
	public Module getModule(long id) {
		Module module = moduleRepository.findById(id).get();
		module.setSections(getModuleSection(id));
		return module;

	}

	public List<Section> getModuleSection(long moduleId) {
		List<Section> sections = new ArrayList<Section>();
		String sql = "SELECT section_id FROM module_sections where module_id=?";
		SqlRowSet set = template.queryForRowSet(sql, moduleId);
		while (set.next()) {
			sections.add(sectionService.getSection(set.getLong(1)));

		}
		return sections;

	}

	public Index saveIndex(Index index) {
		return indexRepository.save(index);

	}
	
	public List<Index> getIndexes() {
		return indexRepository.findAll();

	}
	
	public Index getIndex(long indexId) {
		Index index = indexRepository.findById(indexId).get();
		index.setModules(moduleRepository.findModulesByIndexId(indexId));
		return index;
	}
	
	public int addModuleToIndex(long moduleId,long indexId) {
		String sql ="INSERT INTO index_modules(module_id,index_id) VALUES(?,?,now()) ";
		return template.update(sql,moduleId,indexId);
	}
	
	public int addSectinModule(long moduleId,long sectionId,double weight) {
		String sql ="INSERT INTO module_sections(module_id,section_id,weight) VALUES(?,?,?) ";
		return template.update(sql,moduleId,sectionId,weight);
	}
	
	
	public int deleteModuleSection(long moduleId,long section) {
		String sql ="DELETE FROM module_sections where module_id=? and section_id=?";
		return template.update(sql,moduleId,section);
	}
	public int deleteModuleIndex(long moduleId,long indexId) {
		String sql ="DELETE FROM index_modules where module_id=? and index_id=?";
		return template.update(sql,moduleId,indexId);
	}
}
