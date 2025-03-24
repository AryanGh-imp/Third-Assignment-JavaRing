package org.project.object;

import org.project.entity.Entity;

public interface Object {
    void use(Entity target);

    String getName();

    String getDescription();

    boolean isUsable();
}
