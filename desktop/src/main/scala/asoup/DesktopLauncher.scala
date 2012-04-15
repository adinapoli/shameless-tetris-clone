
import asoup.Game
import asoup.Const.{screenWidth, screenHeight}
import com.badlogic.gdx.backends.jogl.JoglApplication

object DesktopLauncher extends App {
  new JoglApplication(new Game(), "Tetris shameless clone",
                      screenWidth, screenHeight, true)
}
