package org.example;

import java.util.List;

public class DevStack {
    private List<String> technologies;

    public DevStack(List<String> technologies) {
        this.technologies = technologies;
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }
}
