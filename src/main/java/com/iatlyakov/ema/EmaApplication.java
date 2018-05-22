package com.iatlyakov.ema;

import com.iatlyakov.ema.entity.OrgType;
import com.iatlyakov.ema.entity.Organization;
import com.iatlyakov.ema.entity.User;
import com.iatlyakov.ema.repository.IOrgTypeRepository;
import com.iatlyakov.ema.repository.IOrganizationRepository;
import com.iatlyakov.ema.repository.IUserRepository;
import com.iatlyakov.ema.service.IOrganizationService;
import com.iatlyakov.ema.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class EmaApplication implements CommandLineRunner   {

	@Autowired
	IUserRepository userRepository;
	@Autowired
	IOrganizationRepository organizationRepository;
	@Autowired
	IOrgTypeRepository orgTypeRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmaApplication.class, args);
	}


	public void run(String... args) throws Exception {
		userRepository.save(new User("Сергей","Иванов","Петрович"));
		userRepository.save(new User("Петр","Петров","Сергеевич"));
		userRepository.save(new User("Семен","Сидоров", "Иванович"));

		orgTypeRepository.save( new OrgType("Продажа компьютерной техники"));
		orgTypeRepository.save( new OrgType("Ремонт компьютерной техники"));
		orgTypeRepository.save(new OrgType("Утилизация химических отходов"));
		orgTypeRepository.save(new OrgType("Страховая компания"));


	}
}