package es.unileon.prg2.patterns.composite;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Suite Composite")
@SelectPackages("es.unileon.prg2.patterns.composite")
@IncludeClassNamePatterns(".*Tests")
class AllTests {
}
