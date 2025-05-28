package com.example;

import com.scrumapp.models.User;
import com.scrumapp.models.Proyectos;

public class Session {
    private static User currentUser;
    private static Proyectos currentProject;

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentProject(Proyectos project) {
        currentProject = project;
    }

    public static Proyectos getCurrentProject() {
        return currentProject;
    }

    public static void clear() {
        currentUser = null;
        currentProject = null;
    }
}

