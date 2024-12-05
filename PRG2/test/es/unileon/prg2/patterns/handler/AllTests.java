package es.unileon.prg2.patterns.handler;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Suite Handler")
@SelectPackages("es.unileon.prg2.patterns.handler")
@IncludeClassNamePatterns(".*Tests")
class AllTests {
}
