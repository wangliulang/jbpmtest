package jbpmtest;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.icss.service.TestHibernateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-activiti.xml"})
public class TranTest {
	
	@Autowired
	private TestHibernateService testHiberService;
	
	@Test
	public void testOneClassTran() {
		testHiberService.testTran();
	}
	
	private  ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	/**
	 * 通过定义好的流程图文件部署，一次只能部署一个流程
	 */
	@Test
	public void deploy() {
	    RepositoryService repositoryService = processEngine.getRepositoryService();
	    Deployment deployment = repositoryService.createDeployment()
	            .addClasspathResource("death/note/lawliet/web/workflow/leave.bpmn").deploy();
	}
}
