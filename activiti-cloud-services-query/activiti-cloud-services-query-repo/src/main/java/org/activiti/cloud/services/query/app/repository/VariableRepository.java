/*
 * Copyright 2018 Alfresco, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.cloud.services.query.app.repository;

import com.querydsl.core.types.dsl.StringPath;
import org.activiti.cloud.services.query.model.QVariable;
import org.activiti.cloud.services.query.model.Variable;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/variables",
        collectionResourceDescription = @Description("Collection of variable instance resources"),
        collectionResourceRel = "variables",
        itemResourceRel = "variable")
public interface VariableRepository extends RestResourceQueryRepository<Variable, Long>, QuerydslPredicateExecutor<Variable>, QuerydslBinderCustomizer<QVariable> {

    @Override
    default void customize(QuerydslBindings bindings,
                           QVariable root) {

        bindings.bind(String.class).first(
                                          (StringPath path, String value) -> path.eq(value));

    }
}