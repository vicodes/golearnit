package com.golearnit.data.module.content.dao;

import com.golearnit.data.module.base.dao.BaseDao;
import com.golearnit.data.module.content.entity.Subjects;

import java.util.List;

public interface SubjectsDAO extends BaseDao<Subjects> {

    List<Subjects> getSubjectByIds(List<String> ids);
}
