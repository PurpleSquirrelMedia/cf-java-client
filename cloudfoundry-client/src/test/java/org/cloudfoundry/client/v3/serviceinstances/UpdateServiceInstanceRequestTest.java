/*
 * Copyright 2013-2021 the original author or authors.
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

package org.cloudfoundry.client.v3.serviceinstances;

import org.cloudfoundry.client.v3.Metadata;
import org.cloudfoundry.client.v3.Relationship;
import org.cloudfoundry.client.v3.ToOneRelationship;
import org.junit.Test;

public class UpdateServiceInstanceRequestTest {

    @Test
    public void testServiceInstanceIdOnly() {
        UpdateServiceInstanceRequest.builder()
            .serviceInstanceId("test-service-instance-id")
            .build();
    }

    @Test(expected = IllegalStateException.class)
    public void noServiceInstanceId() {
        UpdateServiceInstanceRequest.builder()
            .metadata(Metadata.builder().build())
            .build();
    }

    @Test
    public void validManagedServiceInstance() {
        UpdateServiceInstanceRequest.builder()
            .metadata(Metadata.builder().build())
            .serviceInstanceId("test-service-instance-id")
            .name("test-service-instance-name")
            .relationships(ServiceInstanceRelationships.builder()
                .servicePlan(ToOneRelationship.builder()
                    .data(Relationship.builder()
                        .id("test-service-plan-id")
                        .build())
                    .build())
                .space(ToOneRelationship.builder()
                    .data(Relationship.builder()
                        .id("test-space-id")
                        .build())
                    .build())
                .build())
            .tags("foo", "bar")
            .parameter("key", "value")
            .build();
    }


}
