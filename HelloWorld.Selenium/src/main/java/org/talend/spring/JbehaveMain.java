package org.talend.spring;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.spring.steps.HelloWorldSteps;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

//@RunWith(JUnitReportingRunner.class)
public class JbehaveMain extends JUnitStories {
	
	@Override
	public Configuration configuration() {
		//System.setProperty("webdriver.gecko.driver", "D:/Software/file/geckodriver.exe");
		return new MostUsefulConfiguration()
				.useStoryControls(new StoryControls().doDryRun(false))
				.useStoryLoader(new LoadFromClasspath(this.getClass()))
				.useStoryReporterBuilder(new StoryReporterBuilder().withReporters(new BDDReport()).withFormats(Format.XML, Format.IDE_CONSOLE,
						Format.CONSOLE, Format.HTML, Format.TXT).withFailureTrace(true).withFailureTraceCompression(true));
	}

	@Override
	protected List<String> storyPaths() {
		// TODO Auto-generated method stub
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromPath("src/main/resources"), "**/*.story",
				"**/exclude_*.story");
	}
    
	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new HelloWorldSteps());
	}
	
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				JbehaveMain jBehaveMain = new JbehaveMain();
				try {
					jBehaveMain.run();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		};
		Thread t = new Thread(r);
		t.start();
}
}
