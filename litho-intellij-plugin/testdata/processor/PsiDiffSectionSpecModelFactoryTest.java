/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@com.facebook.litho.sections.annotations.DiffSectionSpec
class TestDiffSectionSpec {

  @com.facebook.litho.sections.annotations.OnDiff
  public static void onCreateChangeSet(
          com.facebook.litho.sections.SectionContext context,
          com.facebook.litho.sections.ChangeSet changeSet,
          @com.facebook.litho.annotations.Prop Diff<Component> component,
          @com.facebook.litho.annotations.Prop(optional = true) Diff<Object> data) {
    final Object prevData = data.getPrevious();
    final Object nextData = data.getNext();
    final com.facebook.litho.Component prevComponent = component.getPrevious();
    final com.facebook.litho.Component nextComponent = component.getNext();

    if (prevComponent == null && nextComponent == null) {
      return;
    }

    if (prevComponent != null && nextComponent == null) {
      changeSet.delete(0, prevData);
      return;
    }
  }
}
