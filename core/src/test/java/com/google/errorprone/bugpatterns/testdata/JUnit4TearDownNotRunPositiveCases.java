/*
 * Copyright 2014 The Error Prone Authors.
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

package com.google.errorprone.bugpatterns.testdata;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author glorioso@google.com
 */
@RunWith(JUnit4.class)
public class JUnit4TearDownNotRunPositiveCases {
  // BUG: Diagnostic contains: @After
  public void tearDown() {}
}

@RunWith(JUnit4.class)
class JUnit4TearDownNotRunPositiveCase2 {
  // BUG: Diagnostic contains: @After
  protected void tearDown() {}
}

@RunWith(JUnit4.class)
class J4BeforeToAfter {
  // BUG: Diagnostic contains: @After
  @Before protected void tearDown() {}
}

@RunWith(JUnit4.class)
class J4BeforeClassToAfterClass {
  // BUG: Diagnostic contains: @AfterClass
  @BeforeClass protected void tearDown() {}
}

class TearDownUnannotatedBaseClass {
  void tearDown() {}
}

@RunWith(JUnit4.class)
class JUnit4TearDownNotRunPositiveCase3 extends TearDownUnannotatedBaseClass {
  // BUG: Diagnostic contains: @After
  protected void tearDown() {}
}

@RunWith(JUnit4.class)
class J4TearDownHasOverride extends TearDownUnannotatedBaseClass {
  // BUG: Diagnostic contains: @After
  @Override protected void tearDown() {}
}

@RunWith(JUnit4.class)
class J4TearDownHasPublicOverride extends TearDownUnannotatedBaseClass {
  // BUG: Diagnostic contains: @After
  @Override public void tearDown() {}
}


