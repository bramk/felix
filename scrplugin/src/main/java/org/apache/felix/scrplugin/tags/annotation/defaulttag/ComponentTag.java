/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.felix.scrplugin.tags.annotation.defaulttag;

import java.util.HashMap;
import java.util.Map;

import org.apache.felix.scrplugin.Constants;
import org.apache.felix.scrplugin.annotations.Component;
import org.apache.felix.scrplugin.tags.JavaClassDescription;

import com.thoughtworks.qdox.model.Annotation;

/**
 * Description of a java tag for components.
 */
public class ComponentTag extends AbstractTag {

    protected final Component annotation;

    /**
     * @param annotation Annotation
     * @param desc Description
     */
    public ComponentTag(Component annotation, JavaClassDescription desc) {
        super(desc, null);
        this.annotation = annotation;
    }

    /**
     * @param annotation Annotation
     * @param desc Description
     */
    public ComponentTag(final Annotation annotation, JavaClassDescription desc) {
        super(desc, null);
        this.annotation = new Component() {

            public boolean componentAbstract() {
                return Util.getValue(annotation, "componentAbstract", false);
            }

            public boolean createPid() {
                return Util.getValue(annotation, "createPid", true);
            }

            public String description() {
                return Util.getValue(annotation, "description", "");
            }

            public boolean ds() {
                return Util.getValue(annotation, "ds", true);
            }

            public boolean enabled() {
                return Util.getValue(annotation, "enabled", true);
            }

            public String factory() {
                return Util.getValue(annotation, "factory", "");
            }

            public boolean immediate() {
                return Util.getValue(annotation, "immediate", false);
            }

            public boolean inherit() {
                return Util.getValue(annotation, "inherit", true);
            }

            public String label() {
                return Util.getValue(annotation, "label", "");
            }

            public boolean metatype() {
                return Util.getValue(annotation, "metatype", false);
            }

            public String name() {
                return Util.getValue(annotation, "name", "");
            }

            public Class<? extends java.lang.annotation.Annotation> annotationType() {
                return null;
            }
        };
    }

    @Override
    public String getName() {
        return Constants.COMPONENT;
    }

    @Override
    public Map<String, String> getNamedParameterMap() {
        final Map<String, String> map = new HashMap<String, String>();

        map.put(Constants.COMPONENT_NAME, emptyToNull(this.annotation.name()));
        map.put(Constants.COMPONENT_LABEL, emptyToNull(this.annotation.label()));
        map.put(Constants.COMPONENT_DESCRIPTION, emptyToNull(this.annotation.description()));
        map.put(Constants.COMPONENT_ENABLED, String.valueOf(this.annotation.enabled()));
        map.put(Constants.COMPONENT_FACTORY, emptyToNull(this.annotation.factory()));
        map.put(Constants.COMPONENT_IMMEDIATE, String.valueOf(this.annotation.immediate()));
        map.put(Constants.COMPONENT_INHERIT, String.valueOf(this.annotation.inherit()));
        map.put(Constants.COMPONENT_METATYPE, String.valueOf(this.annotation.metatype()));
        map.put(Constants.COMPONENT_ABSTRACT, String.valueOf(this.annotation.componentAbstract()));
        map.put(Constants.COMPONENT_DS, String.valueOf(this.annotation.ds()));
        map.put(Constants.COMPONENT_CREATE_PID, String.valueOf(this.annotation.createPid()));

        return map;
    }

}
