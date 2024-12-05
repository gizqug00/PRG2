package es.unileon.prg2.patterns.iterator;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Suite Iterator")
@SelectPackages("es.unileon.prg2.patterns.iterator")
@IncludeClassNamePatterns(".*Tests")
class AllTests {
}
