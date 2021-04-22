package com.deligence.configuration;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Solution {
	
private long id;
private long questionId;

private String answer;

private long answerId;

private double score;



}
