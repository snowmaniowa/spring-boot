package com.boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Shipwreck;

@RestController
@RequestMapping("/api/v1/")		//# class level request mapping annotation
public class ShipWreckController {

		@RequestMapping(value = "shipwrecks", method=RequestMethod.GET)
		public List<Shipwreck> list(){
			return ShipwreckStub.list();
		}
		
		@RequestMapping(value="shipwrecks", method=RequestMethod.POST)
		public Shipwreck create(@RequestBody Shipwreck shipwreck){
			return ShipwreckStub.create(shipwreck);
		}

		//# {id} -- anytime there is a input parameter with curly braces, @PathVariable is a MUST
		@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.GET)
		public Shipwreck get(@PathVariable Long id){
			return ShipwreckStub.get(id);
		}

		@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
		public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
			return ShipwreckStub.update(id, shipwreck);
		}

		@RequestMapping(name="shipwrecks/{id}", method=RequestMethod.DELETE)
		public Shipwreck delete(@PathVariable Long id){
			return ShipwreckStub.delete(id);
		}
		
}

//logging.level.org.springframework.web=DEBUG
//
//server.port=8080
//
//spring.h2.console.enabled=true
//spring.h2.console.path=/h2
//
//spring.datasource.url=jdbc:h2:file:~/dasboot
//spring.datasource.username=sa
//spring.datasource.password=
//spring.datasource.driver-class-name=org.h2.Driver
//
//spring.datasource.max-active=10
//spring.datasource.max-idle=8
//spring.datasource.max-wait=10000
//spring.datasource.min-evictable-idle-time-millis=1000
//spring.datasource.min-idle=8
//spring.datasource.time-between-eviction-runs-millis=1
//
//#flyway.baseline-on-migrate=false
//#spring.jpa.hibernate.ddl-auto=false
//
//#datasource.flyway.url=jdbc:h2:file:~/dasboot
//#datasource.flyway.username=sa
//#datasource.flyway.password=
//#datasource.flyway.driver-class-name=org.h2.Driver

