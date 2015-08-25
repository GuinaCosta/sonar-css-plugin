/*
 * SonarQube CSS Plugin
 * Copyright (C) 2013 Tamas Kende and David RACODON
 * kende.tamas@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.css.checks;

import org.junit.Test;
import org.sonar.css.CssAstScanner;
import org.sonar.squidbridge.api.SourceFile;
import org.sonar.squidbridge.checks.CheckMessagesVerifier;

import java.io.File;

public class BulletproofFontFaceTest {

  @Test
  public void test() {
    BulletproofFontFace check = new BulletproofFontFace();
    SourceFile file = CssAstScanner.scanSingleFile(new File(
      "src/test/resources/checks/fontface.css"), check);
    CheckMessagesVerifier.verify(file.getCheckMessages()).next()
      .atLine(1).withMessage("Check that the first file is the .eot file and that the workaround for IE is set")
      .noMore();
  }


  @Test
  public void test3() {
    BulletproofFontFace check = new BulletproofFontFace();
    SourceFile file = CssAstScanner.scanSingleFile(new File(
      "src/test/resources/checks/fontface2.css"), check);
    CheckMessagesVerifier.verify(file.getCheckMessages()).noMore();
  }

  @Test
  public void test4() {
    BulletproofFontFace check = new BulletproofFontFace();
    SourceFile file = CssAstScanner.scanSingleFile(new File(
      "src/test/resources/checks/fontface3.css"), check);
    CheckMessagesVerifier.verify(file.getCheckMessages()).next()
      .atLine(1).withMessage("Check that the first file is the .eot file and that the workaround for IE is set")
      .noMore();
  }


  @Test
  public void test2(){
    BulletproofFontFace check = new BulletproofFontFace();
    SourceFile file = CssAstScanner.scanSingleFile(new File(
      "src/test/resources/checks/sonarcss-19.css"), check);
    CheckMessagesVerifier.verify(file.getCheckMessages()).noMore();
  }

}
