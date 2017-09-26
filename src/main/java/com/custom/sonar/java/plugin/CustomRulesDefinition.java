
package com.custom.sonar.java.plugin;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.plugins.java.Java;
import org.sonar.squidbridge.annotations.AnnotationBasedRulesDefinition;

/**
 * Declare rule metadata in server repository of rules. 
 * That allows to list the rules in the page "Rules".
 */
public class CustomRulesDefinition implements RulesDefinition {

  public static final String REPOSITORY_KEY = "ccspRepo";
  public static final String Extension = "java";

  @Override
  public void define(Context context) {
    NewRepository repository = context.createRepository(REPOSITORY_KEY, Java.KEY);
    repository.setName(REPOSITORY_KEY);

    AnnotationBasedRulesDefinition.load(repository, Extension, RulesList.getChecks());
    repository.done();
  }
}	