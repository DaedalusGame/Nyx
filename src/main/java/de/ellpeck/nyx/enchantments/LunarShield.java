package de.ellpeck.nyx.enchantments;

import de.ellpeck.nyx.capabilities.NyxWorld;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;

import static net.minecraft.inventory.EntityEquipmentSlot.*;

public class LunarShield extends NyxEnchantment {
    public LunarShield() {
        super("lunar_shield", Rarity.UNCOMMON, EnumEnchantmentType.ARMOR, new EntityEquipmentSlot[]{HEAD, CHEST, LEGS, FEET});
    }

    @Override
    public int calcModifierDamage(int level, DamageSource source) {
        if (source.canHarmInCreative()) {
            return 0;
        } else {
            return MathHelper.floor((level + 1) * NyxWorld.moonPhase);
        }
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }

    @Override
    protected boolean canApplyTogether(Enchantment ench) {
        return super.canApplyTogether(ench) && !(ench instanceof EnchantmentProtection);
    }

}
