package com.seotoaster.steps;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
	format = {"pretty", "html:target/cucumber"},
	features = {"classpath:com/seotoaster/features"})
public class RunCukesTest {}
