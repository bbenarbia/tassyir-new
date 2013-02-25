package net.bbenaissa.tassyir.repository;

import java.util.List;

import net.bbenaissa.tassyir.model.Parameter;

import org.springframework.dao.DataAccessException;

public interface ParameterRepository {

	Parameter findParameterByName(String name) throws DataAccessException;

	Parameter load(Integer id);

	 List<Parameter> getAllParameter();

	 void save(Parameter parameter);

	 void delete(Parameter pser);

	 Integer delete(Integer id);

	 void save(Parameter... entities);

	 void flush();

	 void clear();

}
