package ink.ptms.adyeshach.common.entity.type

import com.google.gson.annotations.Expose
import ink.ptms.adyeshach.api.nms.NMS
import ink.ptms.adyeshach.common.entity.EntityTypes
import org.bukkit.entity.Player

/**
 * @author sky
 * @date 2020/8/4 23:15
 */
class AdyExperienceOrb : AdyEntity(EntityTypes.EXPERIENCE_ORB) {

    @Expose
    var amount = 1

    override fun visible(viewer: Player, visible: Boolean): Boolean {
        return if (visible) {
            spawn(viewer) {
                NMS.INSTANCE.spawnEntityExperienceOrb(viewer, index, position.toLocation(), amount)
            }
        } else {
            destroy(viewer) {
                NMS.INSTANCE.destroyEntity(viewer, index)
            }
        }
    }
}