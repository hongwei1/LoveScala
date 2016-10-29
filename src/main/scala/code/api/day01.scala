
package code.api


/**
 * Open Bank Project - API
 * Copyright (C) 2011-2016, TESOBE / Music Pictures Ltd
 * *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * *
 * Email: contact@tesobe.com
 * TESOBE Ltd.
 * Osloer Strasse 16/17
 * Berlin 13359, Germany
 * *
 * This product includes software developed at
 * TESOBE (http://www.tesobe.com/)
 */
//class Basic {
//
//}

/**
 * @author zhanghongwei
 */
object Basic {
  def hello(name :String) : String ={
    "Hello:"+name
  }
  
  def helloScala(){
    printf("hello Scala!")
  }
  
  def main(args: Array[String]): Unit = {
   println( hello("hongwei"))
  }
}
