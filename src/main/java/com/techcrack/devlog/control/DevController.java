package com.techcrack.devlog.control;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techcrack.devlog.DeveloperService;
import com.techcrack.devlog.entity.Developer;
import com.techcrack.devlog.exception.DeveloperNotFoundException;
import com.techcrack.devlog.repos.DeveloperRepository;

@RestController
public class DevController {
	
	@Autowired
	private DeveloperRepository devRepo;
	
	@Autowired
	private DeveloperService devSer;
	
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@GetMapping("dev/{id}")
	public Developer getDeveloperById(@PathVariable Integer id) {
		var op = devRepo.findById(id);
		
		if (op.isEmpty()) {
			throw new DeveloperNotFoundException("Invalid Developer Id : " + id);
		}
		
		return op.get();
	}
	
	@PutMapping("dev/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateData(@PathVariable Integer id, @RequestBody Developer dev)  {
		Optional<Developer> sDev = devRepo.findById(id);
		
		if (sDev.isEmpty()) {
			throw new DeveloperNotFoundException("Given Id " + id + " No Developer existing...");
		}
		
		devSer.updatePartialData(sDev.get(), dev);
		
		devRepo.save(sDev.get());
	}
	
	@PostMapping("/dev")
	public ResponseEntity<Object> saveDev(@RequestBody Developer dev) {
		
		log.warn("Dev Data Reached Controller : " + dev);
		
		devSer.fillDev(dev, dev.getProjects(), dev.getLogs());
		
		Developer sDev = devRepo.save(dev);
		
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(sDev.getId())
						.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/dev")
	@ResponseStatus(HttpStatus.FOUND)
	public List<Developer> getDevMatchOnSkill(@RequestParam String skill) {
		return devRepo.getDevelopersBySkill(skill);
	}
	
//	@ExceptionHandler(Develop)
//	public 
}
