package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Skill;

public interface SkillService {

	Skill findSkill(int id);

	void saveSkill(Skill skill);
}
