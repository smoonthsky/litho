/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
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

package com.facebook.litho;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static org.junit.Assert.assertTrue;

import com.facebook.litho.testing.testrunner.LithoTestRunner;
import com.facebook.litho.widget.Text;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(LithoTestRunner.class)
public class RequiredPropsTest {

  private ComponentContext mContext;

  @Before
  public void setup() throws Exception {
    mContext = new ComponentContext(getApplicationContext());
  }

  @Test
  public void testWithoutRequiredProps() {
    String error = "";
    try {
      Text.create(mContext).build();
    } catch (IllegalStateException e) {
      error = e.getMessage();
    }
    assertTrue("Error message did not mention the missing required prop", error.contains("text"));
  }

  @Test
  public void testWithRequiredProps() {
    Text.create(mContext).text("text").build();
  }
}
