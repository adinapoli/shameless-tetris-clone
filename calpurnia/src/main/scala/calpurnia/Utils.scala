package calpurnia

/**
 * Created with IntelliJ IDEA.
 * User: alfredodinapoli
 * Date: 12/04/12
 * Time: 19:19
 * To change this template use File | Settings | File Templates.
 */

object Utils {

  /**
   * A semantic operator equal to the Lisp's when. Execute the body
   * when the pred evaluates to true.
   * @param condition A predicate or value that evaluate to a Boolean
   * @param block A valid block of scala code
   */
  def when (condition : => Boolean)( block : => Unit)
  {
    if (condition){ block }
  }
}
