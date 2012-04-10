
import asoup.Game
import com.badlogic.gdx.backends.jogl.JoglApplication

object DesktopLauncher extends App {
  new JoglApplication(new Game(), "Tetris shameless clone", 320, 480, true)
}
