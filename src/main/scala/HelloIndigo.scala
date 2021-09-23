import HelloIndigo.config
import indigo._

import scala.util.Random
import scala.scalajs.js.annotation.JSExportTopLevel

@JSExportTopLevel("IndigoGame")
object HelloIndigo extends IndigoSandbox[Unit, Unit] {
  val config: GameConfig =
    GameConfig.default

  val animations: Set[Animation] = Set()

  val assetName = AssetName("snake")

  val assets: Set[indigo.AssetType] = Set(
    AssetType.Image(assetName, AssetPath("assets/snake.png"))
  )

  val fonts: Set[FontInfo] = Set()

  val shaders: Set[Shader] = Set()

  def setup(
             assetCollection: AssetCollection,
             dice: Dice
           ): Outcome[Startup[Unit]] =
    Outcome(Startup.Success(()))

  def initialModel(startupData: Unit): Outcome[Unit] =
    Outcome(())

  def updateModel(
                   context: FrameContext[Unit],
                   model: Unit
                 ): GlobalEvent => Outcome[Unit] =
    _ => Outcome(())

  def present(
               context: FrameContext[Unit],
               model: Unit
             ): Outcome[SceneUpdateFragment] =
    Outcome(
      SceneUpdateFragment(
        Graphic(Rectangle(0, 0, 36, 12), 1, Material.Bitmap(assetName))
          .withCrop(Rectangle(List(0,12,24)(Random.nextInt(3)), 0, 12, 12))
          .withRef(6, 6)
          .moveTo(
            Signal
              .Orbit(config.viewport.giveDimensions(1).center, 30)
              .map(_.toPoint)
              .at(context.gameTime.running)
          )
      )
    )
}
