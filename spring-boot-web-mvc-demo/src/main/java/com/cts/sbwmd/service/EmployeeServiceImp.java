package com.cts.sbwmd.service;

import org.springframework.stereotype.Service;

import com.cts.sbwmd.model.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Override
	public Employee computeAllowences(Employee e) {
		e.setHra(e.getBasic() * 0.23);
		e.setTa(e.getBasic() * 0.13);
		return e;
	}

}
