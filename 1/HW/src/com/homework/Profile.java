package com.homework;

import java.util.List;

public final class Profile {
    private final String firstname;
    private final String lastname;
    private final String profile;
    private List<String> skills;

    Profile(String firstname, String lastname, String profile, List<String> skills) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.profile = profile;
        this.skills = List.copyOf(skills);
    }

    public String getProfile() {
        return this.profile;
    }

    public String getFullname() {
        return this.lastname + ' ' + this.firstname;
    }

    public List<String> getSkills() {
        return List.copyOf(this.skills);
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s%n", this.getFullname(), this.profile, String.join(", ", skills));
    }
}