package com.ufukuzun.kodility.domain.challenge;

import com.ufukuzun.kodility.enums.Lingo;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Challenge {

    @Id
    private String id;

    private Map<Lingo, String> descriptions = new HashMap<Lingo, String>();

    private List<String> inputTypes = new ArrayList<String>();

    private String outputType;

    private List<TestCase> testCases = new ArrayList<TestCase>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<Lingo, String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(Map<Lingo, String> descriptions) {
        this.descriptions = descriptions;
    }

    public String getDescriptionFor(String lingoShortName) {
        Lingo lingo = Lingo.getLingo(lingoShortName);
        return descriptions.get(lingo);
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<TestCase> testCases) {
        this.testCases = testCases;
    }

    public List<String> getInputTypes() {
        return inputTypes;
    }

    public void setInputTypes(List<String> inputTypes) {
        this.inputTypes = inputTypes;
    }

    public String getOutputType() {
        return outputType;
    }

    public void setOutputType(String outputType) {
        this.outputType = outputType;
    }

    public void addTestCase(TestCase testCase) {
        testCases.add(testCase);
    }
}