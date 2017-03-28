/*
 * Copyright 2014 Ranjan Kumar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.restfeel.entity;

import javax.persistence.ManyToOne;

@Deprecated
public class Star extends NamedEntity {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    private User user;

    @ManyToOne
    private Workspace workspace;

    @ManyToOne
    private Project project;

    @ManyToOne
    private BaseNode baseNode;

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public Workspace getWorkspace() {
	return workspace;
    }

    public void setWorkspace(Workspace workspace) {
	this.workspace = workspace;
    }

    public Project getProject() {
	return project;
    }

    public void setProject(Project project) {
	this.project = project;
    }

    public BaseNode getBaseNode() {
	return baseNode;
    }

    public void setBaseNode(BaseNode baseNode) {
	this.baseNode = baseNode;
    }

}