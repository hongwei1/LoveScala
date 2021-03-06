// These are meant to be typed into the REPL. You can also run
// scala -Xnojline < repl-session.scala to run them all at once.

object Number {
  def unapply(input: String): Option[Int] =
    try {
      Some(Integer.parseInt(input.trim))
    } catch {
      case ex: NumberFormatException => None
    }
}

val Number(n) = "1729"

object Name {
  def unapply(input: String): Option[(String, String)] = {
    val pos = input.indexOf(" ")
    if (pos == -1) None
    else Some((input.substring(0, pos), input.substring(pos + 1)))
  }
}

object IsCompound {
  def unapply(input: String): Boolean = input.contains(" ")
}

val author = "Peter van der Linden"

author match {
  case Name(first, last @ IsCompound()) => last.split("\\s+").length
     // Matches if the author is Peter van der Linden
  case Name(first, last) => 1
}
