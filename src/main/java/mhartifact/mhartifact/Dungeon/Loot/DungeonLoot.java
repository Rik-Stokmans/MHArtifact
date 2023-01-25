package mhartifact.mhartifact.Dungeon.Loot;

import mhartifact.mhartifact.Dungeon.Dungeon;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static mhartifact.mhartifact.Portals.Doors.getDungeonOfPlayer;
import static mhartifact.mhartifact.Utils.ChatUtils.format;

public class DungeonLoot implements Listener {

    public ArrayList<ItemStack> dungeonLoot;

    //Money Items
    public static ItemStack goldNugget;
    public static ItemStack gold;
    public static ItemStack goldBlock;
    public static ItemStack liquidGold;

    //Mob Drops
    public static ItemStack potato;
    public static ItemStack ratHair;
    public static ItemStack rancidFlesh;
    public static ItemStack goblinTooth;
    public static ItemStack yetiFur;
    public static ItemStack woodScrap;
    public static ItemStack viralTentacle;
    public static ItemStack viscousSlime;
    public static ItemStack wybelFluff;
    public static ItemStack wringglingDarkness;
    public static ItemStack wornCoin;
    public static ItemStack woodSnippet;
    public static ItemStack wool;
    public static ItemStack wolfFang;
    public static ItemStack windOrnament;
    public static ItemStack wendigoBone;
    public static ItemStack werewolfTail;
    public static ItemStack branch;
    public static ItemStack warpedSkin;
    public static ItemStack usedFireball;
    public static ItemStack unsettelingSoul;
    public static ItemStack unmeltableIce;
    public static ItemStack undeadHeart;
    public static ItemStack unicornHorn;
    public static ItemStack unholySpirit;
    public static ItemStack thinQuill;
    public static ItemStack thornedTusk;
    public static ItemStack tornSkin;
    public static ItemStack toughBone;
    public static ItemStack toughSkin;
    public static ItemStack toxicLumps;
    public static ItemStack toxicSpores;
    public static ItemStack trollHair;
    public static ItemStack truffle;
    public static ItemStack turtleShell;
    public static ItemStack thickVines;
    public static ItemStack squidBeak;
    public static ItemStack squidBrain;
    public static ItemStack squidInc;
    public static ItemStack stickyFern;
    public static ItemStack stolenGoods;
    public static ItemStack stolenPearls;
    public static ItemStack strangeGeode;
    public static ItemStack stretchedHide;
    public static ItemStack strongFlesh;
    public static ItemStack sturdyFlesh;
    public static ItemStack sugarStick;
    public static ItemStack swooperWing;
    public static ItemStack sylphidTears;
    public static ItemStack tannedFlesh;
    public static ItemStack tenderPork;
    public static ItemStack tendonClump;
    public static ItemStack tentacle;
    public static ItemStack terracottaChunk;
    public static ItemStack thickMud;
    public static ItemStack spiderFang;
    public static ItemStack spiderLeg;
    public static ItemStack soulEssence;
    public static ItemStack soggyStone;
    public static ItemStack spiderEggs;
    public static ItemStack snakeTooth;
    public static ItemStack snakeSkin;
    public static ItemStack snakeEye;
    public static ItemStack softBlueWool;
    public static ItemStack softGreenWool;
    public static ItemStack softRedWool;
    public static ItemStack softWhiteWool;
    public static ItemStack softYellowWool;
    public static ItemStack softSand;
    public static ItemStack softSilk;
    public static ItemStack smoothSilt;
    public static ItemStack slimySkin;
    public static ItemStack smokeBomb;
    public static ItemStack silverFeather;
    public static ItemStack skyFlux;
    public static ItemStack skyStone;
    public static ItemStack sharpClaw;
    public static ItemStack sharpEdge;
    public static ItemStack sharpStone;
    public static ItemStack shatteredBlade;
    public static ItemStack shimmeringJewel;
    public static ItemStack shiningWool;
    public static ItemStack shinyPebble;
    public static ItemStack shreddedBone;
    public static ItemStack seaSalt;
    public static ItemStack seabirdFeather;
    public static ItemStack seabirdEgg;
    public static ItemStack seaGrass;
    public static ItemStack serpentTongue;
    public static ItemStack severedHeart;
    public static ItemStack severedLeg;
    public static ItemStack rottingLog;
    public static ItemStack rottingBone;
    public static ItemStack royalBlood;
    public static ItemStack saltWater;
    public static ItemStack salt;
    public static ItemStack scarabHusk;
    public static ItemStack scarredLeather;
    public static ItemStack rottenFlesh;
    public static ItemStack rootsOfEternity;
    public static ItemStack rose;
    public static ItemStack riverClay;
    public static ItemStack ritualCatalyst;
    public static ItemStack retinalMembrane;
    public static ItemStack retinalBarbs;
    public static ItemStack rigidFin;
    public static ItemStack relicOfTheFuture;
    public static ItemStack reinforcedLeather;
    public static ItemStack regenerativeSpike;
    public static ItemStack razorSharpTooth;
    public static ItemStack rabbitCarcase;
    public static ItemStack ursineClaw;
    public static ItemStack zombieBrain;
    public static ItemStack soulStone;
    public static ItemStack sharpeningStone;
    public static ItemStack roastedTissue;
    public static ItemStack quartzCluster;
    public static ItemStack outdatedNewspaper;
    public static ItemStack novaBloom;
    public static ItemStack mysteriousMist;
    public static ItemStack oldTreasure;
    public static ItemStack royalCake;
    public static ItemStack purestTear;
    public static ItemStack pricklyGrass;
    public static ItemStack pluckedFeather;
    public static ItemStack poisonSac;
    public static ItemStack pirateBeard;
    public static ItemStack pinkWool;
    public static ItemStack pegasusFeather;
    public static ItemStack pigBlood;
    public static ItemStack pigmanMeat;
    public static ItemStack opticFiber;
    public static ItemStack orcEye;
    public static ItemStack orcSkin;
    public static ItemStack orkTeeth;
    public static ItemStack owlFeather;

    //constructor
    public DungeonLoot() {
        this.dungeonLoot = new ArrayList<>();
    }

    public static void initLootItems() {

        //Gold Nugget Item
        goldNugget = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta goldNuggetItemMeta = goldNugget.getItemMeta();
        goldNuggetItemMeta.setDisplayName(format("&6Gold Nugget"));
        goldNugget.setItemMeta(goldNuggetItemMeta);

        //Gold Item
        gold = new ItemStack(Material.GOLD_INGOT);
        ItemMeta goldItemMeta = gold.getItemMeta();
        goldItemMeta.setDisplayName(format("&6Gold Bar"));
        gold.setItemMeta(goldItemMeta);

        //Gold Block Item
        goldBlock = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta goldBlockItemMeta = goldBlock.getItemMeta();
        goldBlockItemMeta.setDisplayName(format("&6Gold Block"));
        goldBlock.setItemMeta(goldBlockItemMeta);

        //Liquid Gold Item
        liquidGold = new ItemStack(Material.HONEY_BOTTLE);
        ItemMeta liquidGoldItemMeta = liquidGold.getItemMeta();
        liquidGoldItemMeta.setDisplayName(format("&6Liquid Gold"));
        liquidGold.setItemMeta(liquidGoldItemMeta);

        //potato Item
        potato = new ItemStack(Material.BARRIER);
        ItemMeta potatoItemMeta = potato.getItemMeta();
        potatoItemMeta.setDisplayName(format("&7Potato"));
        potato.setItemMeta(potatoItemMeta);

        //ratHair Item
        ratHair = new ItemStack(Material.BARRIER);
        ItemMeta ratHairItemMeta = ratHair.getItemMeta();
        ratHairItemMeta.setDisplayName(format("&7Rat Hair"));
        ratHair.setItemMeta(ratHairItemMeta);

        //rancidFlesh Item
        rancidFlesh = new ItemStack(Material.BARRIER);
        ItemMeta rancidFleshItemMeta = rancidFlesh.getItemMeta();
        rancidFleshItemMeta.setDisplayName(format("&7Rancid Flesh"));
        rancidFlesh.setItemMeta(rancidFleshItemMeta);

        //goblinTooth Item
        goblinTooth = new ItemStack(Material.BARRIER);
        ItemMeta goblinToothItemMeta = goblinTooth.getItemMeta();
        goblinToothItemMeta.setDisplayName(format("&7Goblin Tooth"));
        goblinTooth.setItemMeta(goblinToothItemMeta);

        //yetiFur Item
        yetiFur = new ItemStack(Material.BARRIER);
        ItemMeta yetiFurItemMeta = yetiFur.getItemMeta();
        yetiFurItemMeta.setDisplayName(format("&7Yeti Fur"));
        yetiFur.setItemMeta(yetiFurItemMeta);

        //woodScrap Item
        woodScrap = new ItemStack(Material.BARRIER);
        ItemMeta woodScrapItemMeta = woodScrap.getItemMeta();
        woodScrapItemMeta.setDisplayName(format("&7Wood Scrap"));
        woodScrap.setItemMeta(woodScrapItemMeta);

        //viralTentacle Item
        viralTentacle = new ItemStack(Material.BARRIER);
        ItemMeta viralTentacleItemMeta = viralTentacle.getItemMeta();
        viralTentacleItemMeta.setDisplayName(format("&7Viral Tentacle"));
        viralTentacle.setItemMeta(viralTentacleItemMeta);

        //viscousSlime Item
        viscousSlime = new ItemStack(Material.BARRIER);
        ItemMeta viscousSlimeItemMeta = viscousSlime.getItemMeta();
        viscousSlimeItemMeta.setDisplayName(format("&7Viscous Slime"));
        viscousSlime.setItemMeta(viscousSlimeItemMeta);

        //wybelFluff Item
        wybelFluff = new ItemStack(Material.BARRIER);
        ItemMeta wybelFluffItemMeta = wybelFluff.getItemMeta();
        wybelFluffItemMeta.setDisplayName(format("&7Wybel Fluff"));
        wybelFluff.setItemMeta(wybelFluffItemMeta);

        //wringglingDarkness Item
        wringglingDarkness = new ItemStack(Material.BARRIER);
        ItemMeta wringglingDarknessItemMeta = wringglingDarkness.getItemMeta();
        wringglingDarknessItemMeta.setDisplayName(format("&7Wringgling Darkness"));
        wringglingDarkness.setItemMeta(wringglingDarknessItemMeta);

        //wornCoin Item
        wornCoin = new ItemStack(Material.BARRIER);
        ItemMeta wornCoinItemMeta = wornCoin.getItemMeta();
        wornCoinItemMeta.setDisplayName(format("&7Worn Coin"));
        wornCoin.setItemMeta(wornCoinItemMeta);

        //woodSnippet Item
        woodSnippet = new ItemStack(Material.BARRIER);
        ItemMeta woodSnippetItemMeta = woodSnippet.getItemMeta();
        woodSnippetItemMeta.setDisplayName(format("&7Wood Snippet"));
        woodSnippet.setItemMeta(woodSnippetItemMeta);

        //wool Item
        wool = new ItemStack(Material.BARRIER);
        ItemMeta woolItemMeta = wool.getItemMeta();
        woolItemMeta.setDisplayName(format("&7Wool"));
        wool.setItemMeta(woolItemMeta);

        //wolfFang Item
        wolfFang = new ItemStack(Material.BARRIER);
        ItemMeta wolfFangItemMeta = wolfFang.getItemMeta();
        wolfFangItemMeta.setDisplayName(format("&7Wolf Fang"));
        wolfFang.setItemMeta(wolfFangItemMeta);

        //windOrnament Item
        windOrnament = new ItemStack(Material.BARRIER);
        ItemMeta windOrnamentItemMeta = windOrnament.getItemMeta();
        windOrnamentItemMeta.setDisplayName(format("&7Wind Ornament"));
        windOrnament.setItemMeta(windOrnamentItemMeta);

        //wendigoBone Item
        wendigoBone = new ItemStack(Material.BARRIER);
        ItemMeta wendigoBoneItemMeta = wendigoBone.getItemMeta();
        wendigoBoneItemMeta.setDisplayName(format("&7Wendigo Bone"));
        wendigoBone.setItemMeta(wendigoBoneItemMeta);

        //werewolfTail Item
        werewolfTail = new ItemStack(Material.BARRIER);
        ItemMeta werewolfTailItemMeta = werewolfTail.getItemMeta();
        werewolfTailItemMeta.setDisplayName(format("&7Werewolf Tail"));
        werewolfTail.setItemMeta(werewolfTailItemMeta);

        //branch Item
        branch = new ItemStack(Material.BARRIER);
        ItemMeta branchItemMeta = branch.getItemMeta();
        branchItemMeta.setDisplayName(format("&7Branch"));
        branch.setItemMeta(branchItemMeta);

        //warpedSkin Item
        warpedSkin = new ItemStack(Material.BARRIER);
        ItemMeta warpedSkinItemMeta = warpedSkin.getItemMeta();
        warpedSkinItemMeta.setDisplayName(format("&7Warped Skin"));
        warpedSkin.setItemMeta(warpedSkinItemMeta);

        //usedFireball Item
        usedFireball = new ItemStack(Material.BARRIER);
        ItemMeta usedFireballItemMeta = usedFireball.getItemMeta();
        usedFireballItemMeta.setDisplayName(format("&7Used Fireball"));
        usedFireball.setItemMeta(usedFireballItemMeta);

        //unsettelingSoul Item
        unsettelingSoul = new ItemStack(Material.BARRIER);
        ItemMeta unsettelingSoulItemMeta = unsettelingSoul.getItemMeta();
        unsettelingSoulItemMeta.setDisplayName(format("&7Unsetteling Soul"));
        unsettelingSoul.setItemMeta(unsettelingSoulItemMeta);

        //unmeltableIce Item
        unmeltableIce = new ItemStack(Material.BARRIER);
        ItemMeta unmeltableIceItemMeta = unmeltableIce.getItemMeta();
        unmeltableIceItemMeta.setDisplayName(format("&7Unmeltable Ice"));
        unmeltableIce.setItemMeta(unmeltableIceItemMeta);

        //undeadHeart Item
        undeadHeart = new ItemStack(Material.BARRIER);
        ItemMeta undeadHeartItemMeta = undeadHeart.getItemMeta();
        undeadHeartItemMeta.setDisplayName(format("&7Undead Heart"));
        undeadHeart.setItemMeta(undeadHeartItemMeta);

        //unicornHorn Item
        unicornHorn = new ItemStack(Material.BARRIER);
        ItemMeta unicornHornItemMeta = unicornHorn.getItemMeta();
        unicornHornItemMeta.setDisplayName(format("&7Unicorn Horn"));
        unicornHorn.setItemMeta(unicornHornItemMeta);

        //unholySpirit Item
        unholySpirit = new ItemStack(Material.BARRIER);
        ItemMeta unholySpiritItemMeta = unholySpirit.getItemMeta();
        unholySpiritItemMeta.setDisplayName(format("&7Unholy Spirit"));
        unholySpirit.setItemMeta(unholySpiritItemMeta);

        //thinQuill Item
        thinQuill = new ItemStack(Material.BARRIER);
        ItemMeta thinQuillItemMeta = thinQuill.getItemMeta();
        thinQuillItemMeta.setDisplayName(format("&7Thin Quill"));
        thinQuill.setItemMeta(thinQuillItemMeta);

        //thornedTusk Item
        thornedTusk = new ItemStack(Material.BARRIER);
        ItemMeta thornedTuskItemMeta = thornedTusk.getItemMeta();
        thornedTuskItemMeta.setDisplayName(format("&7Thorned Tusk"));
        thornedTusk.setItemMeta(thornedTuskItemMeta);

        //tornSkin Item
        tornSkin = new ItemStack(Material.BARRIER);
        ItemMeta tornSkinItemMeta = tornSkin.getItemMeta();
        tornSkinItemMeta.setDisplayName(format("&7Torn Skin"));
        tornSkin.setItemMeta(tornSkinItemMeta);

        //toughBone Item
        toughBone = new ItemStack(Material.BARRIER);
        ItemMeta toughBoneItemMeta = toughBone.getItemMeta();
        toughBoneItemMeta.setDisplayName(format("&7Tough Bone"));
        toughBone.setItemMeta(toughBoneItemMeta);

        //toughSkin Item
        toughSkin = new ItemStack(Material.BARRIER);
        ItemMeta toughSkinItemMeta = toughSkin.getItemMeta();
        toughSkinItemMeta.setDisplayName(format("&7Tough Skin"));
        toughSkin.setItemMeta(toughSkinItemMeta);

        //toxicLumps Item
        toxicLumps = new ItemStack(Material.BARRIER);
        ItemMeta toxicLumpsItemMeta = toxicLumps.getItemMeta();
        toxicLumpsItemMeta.setDisplayName(format("&7Toxic Lumps"));
        toxicLumps.setItemMeta(toxicLumpsItemMeta);

        //toxicSpores Item
        toxicSpores = new ItemStack(Material.BARRIER);
        ItemMeta toxicSporesItemMeta = toxicSpores.getItemMeta();
        toxicSporesItemMeta.setDisplayName(format("&7Toxic Spores"));
        toxicSpores.setItemMeta(toxicSporesItemMeta);

        //trollHair Item
        trollHair = new ItemStack(Material.BARRIER);
        ItemMeta trollHairItemMeta = trollHair.getItemMeta();
        trollHairItemMeta.setDisplayName(format("&7Troll Hair"));
        trollHair.setItemMeta(trollHairItemMeta);

        //truffle Item
        truffle = new ItemStack(Material.BARRIER);
        ItemMeta truffleItemMeta = truffle.getItemMeta();
        truffleItemMeta.setDisplayName(format("&7Truffle"));
        truffle.setItemMeta(truffleItemMeta);

        //turtleShell Item
        turtleShell = new ItemStack(Material.BARRIER);
        ItemMeta turtleShellItemMeta = turtleShell.getItemMeta();
        turtleShellItemMeta.setDisplayName(format("&7Turtle Shell"));
        turtleShell.setItemMeta(turtleShellItemMeta);

        //thickVines Item
        thickVines = new ItemStack(Material.BARRIER);
        ItemMeta thickVinesItemMeta = thickVines.getItemMeta();
        thickVinesItemMeta.setDisplayName(format("&7Thick Vines"));
        thickVines.setItemMeta(thickVinesItemMeta);

        //squidBeak Item
        squidBeak = new ItemStack(Material.BARRIER);
        ItemMeta squidBeakItemMeta = squidBeak.getItemMeta();
        squidBeakItemMeta.setDisplayName(format("&7Squid Beak"));
        squidBeak.setItemMeta(squidBeakItemMeta);

        //squidBrain Item
        squidBrain = new ItemStack(Material.BARRIER);
        ItemMeta squidBrainItemMeta = squidBrain.getItemMeta();
        squidBrainItemMeta.setDisplayName(format("&7Squid Brain"));
        squidBrain.setItemMeta(squidBrainItemMeta);

        //squidInc Item
        squidInc = new ItemStack(Material.BARRIER);
        ItemMeta squidIncItemMeta = squidInc.getItemMeta();
        squidIncItemMeta.setDisplayName(format("&7Squid Inc"));
        squidInc.setItemMeta(squidIncItemMeta);

        //stickyFern Item
        stickyFern = new ItemStack(Material.BARRIER);
        ItemMeta stickyFernItemMeta = stickyFern.getItemMeta();
        stickyFernItemMeta.setDisplayName(format("&7Sticky Fern"));
        stickyFern.setItemMeta(stickyFernItemMeta);

        //stolenGoods Item
        stolenGoods = new ItemStack(Material.BARRIER);
        ItemMeta stolenGoodsItemMeta = stolenGoods.getItemMeta();
        stolenGoodsItemMeta.setDisplayName(format("&7Stolen Goods"));
        stolenGoods.setItemMeta(stolenGoodsItemMeta);

        //stolenPearls Item
        stolenPearls = new ItemStack(Material.BARRIER);
        ItemMeta stolenPearlsItemMeta = stolenPearls.getItemMeta();
        stolenPearlsItemMeta.setDisplayName(format("&7Stolen Pearls"));
        stolenPearls.setItemMeta(stolenPearlsItemMeta);

        //strangeGeode Item
        strangeGeode = new ItemStack(Material.BARRIER);
        ItemMeta strangeGeodeItemMeta = strangeGeode.getItemMeta();
        strangeGeodeItemMeta.setDisplayName(format("&7Strange Geode"));
        strangeGeode.setItemMeta(strangeGeodeItemMeta);

        //stretchedHide Item
        stretchedHide = new ItemStack(Material.BARRIER);
        ItemMeta stretchedHideItemMeta = stretchedHide.getItemMeta();
        stretchedHideItemMeta.setDisplayName(format("&7Stretched Hide"));
        stretchedHide.setItemMeta(stretchedHideItemMeta);

        //StrongFlesh Item
        strongFlesh = new ItemStack(Material.BARRIER);
        ItemMeta StrongFleshItemMeta = strongFlesh.getItemMeta();
        StrongFleshItemMeta.setDisplayName(format("&7Strong Flesh"));
        strongFlesh.setItemMeta(StrongFleshItemMeta);

        //sturdyFlesh Item
        sturdyFlesh = new ItemStack(Material.BARRIER);
        ItemMeta sturdyFleshItemMeta = sturdyFlesh.getItemMeta();
        sturdyFleshItemMeta.setDisplayName(format("&7Sturdy Flesh"));
        sturdyFlesh.setItemMeta(sturdyFleshItemMeta);

        //sugarStick Item
        sugarStick = new ItemStack(Material.BARRIER);
        ItemMeta sugarStickItemMeta = sugarStick.getItemMeta();
        sugarStickItemMeta.setDisplayName(format("&7Sugar Stick"));
        sugarStick.setItemMeta(sugarStickItemMeta);

        //swooperWing Item
        swooperWing = new ItemStack(Material.BARRIER);
        ItemMeta swooperWingItemMeta = swooperWing.getItemMeta();
        swooperWingItemMeta.setDisplayName(format("&7Swooper Wing"));
        swooperWing.setItemMeta(swooperWingItemMeta);

        //sylphidTears Item
        sylphidTears = new ItemStack(Material.BARRIER);
        ItemMeta sylphidTearsItemMeta = sylphidTears.getItemMeta();
        sylphidTearsItemMeta.setDisplayName(format("&7Sylphid Tears"));
        sylphidTears.setItemMeta(sylphidTearsItemMeta);

        //tannedFlesh Item
        tannedFlesh = new ItemStack(Material.BARRIER);
        ItemMeta tannedFleshItemMeta = tannedFlesh.getItemMeta();
        tannedFleshItemMeta.setDisplayName(format("&7Tanned Flesh"));
        tannedFlesh.setItemMeta(tannedFleshItemMeta);

        //tenderPork Item
        tenderPork = new ItemStack(Material.BARRIER);
        ItemMeta tenderPorkItemMeta = tenderPork.getItemMeta();
        tenderPorkItemMeta.setDisplayName(format("&7Tender Pork"));
        tenderPork.setItemMeta(tenderPorkItemMeta);

        //tendonClump Item
        tendonClump = new ItemStack(Material.BARRIER);
        ItemMeta tendonClumpItemMeta = tendonClump.getItemMeta();
        tendonClumpItemMeta.setDisplayName(format("&7Tendon Clump"));
        tendonClump.setItemMeta(tendonClumpItemMeta);

        //tentacle Item
        tentacle = new ItemStack(Material.BARRIER);
        ItemMeta tentacleItemMeta = tentacle.getItemMeta();
        tentacleItemMeta.setDisplayName(format("&7Tentacle"));
        tentacle.setItemMeta(tentacleItemMeta);

        //terracottaChunk Item
        terracottaChunk = new ItemStack(Material.BARRIER);
        ItemMeta terracottaChunkItemMeta = terracottaChunk.getItemMeta();
        terracottaChunkItemMeta.setDisplayName(format("&7Terracotta Chunk"));
        terracottaChunk.setItemMeta(terracottaChunkItemMeta);

        //thickMud Item
        thickMud = new ItemStack(Material.BARRIER);
        ItemMeta thickMudItemMeta = thickMud.getItemMeta();
        thickMudItemMeta.setDisplayName(format("&7Thick Mud"));
        thickMud.setItemMeta(thickMudItemMeta);

        //spiderFang Item
        spiderFang = new ItemStack(Material.BARRIER);
        ItemMeta spiderFangItemMeta = spiderFang.getItemMeta();
        spiderFangItemMeta.setDisplayName(format("&7Spider Fang"));
        spiderFang.setItemMeta(spiderFangItemMeta);

        //spiderLeg Item
        spiderLeg = new ItemStack(Material.BARRIER);
        ItemMeta spiderLegItemMeta = spiderLeg.getItemMeta();
        spiderLegItemMeta.setDisplayName(format("&7Spider Leg"));
        spiderLeg.setItemMeta(spiderLegItemMeta);

        //soulEssence Item
        soulEssence = new ItemStack(Material.BARRIER);
        ItemMeta soulEssenceItemMeta = soulEssence.getItemMeta();
        soulEssenceItemMeta.setDisplayName(format("&7Soul Essence"));
        soulEssence.setItemMeta(soulEssenceItemMeta);

        //soggyStone Item
        soggyStone = new ItemStack(Material.BARRIER);
        ItemMeta soggyStoneItemMeta = soggyStone.getItemMeta();
        soggyStoneItemMeta.setDisplayName(format("&7Soggy Stone"));
        soggyStone.setItemMeta(soggyStoneItemMeta);

        //spiderEggs Item
        spiderEggs = new ItemStack(Material.BARRIER);
        ItemMeta spiderEggsItemMeta = spiderEggs.getItemMeta();
        spiderEggsItemMeta.setDisplayName(format("&7Spider Eggs"));
        spiderEggs.setItemMeta(spiderEggsItemMeta);

        //snakeTooth Item
        snakeTooth = new ItemStack(Material.BARRIER);
        ItemMeta snakeToothItemMeta = snakeTooth.getItemMeta();
        snakeToothItemMeta.setDisplayName(format("&7Snake Tooth"));
        snakeTooth.setItemMeta(snakeToothItemMeta);

        //snakeSkin Item
        snakeSkin = new ItemStack(Material.BARRIER);
        ItemMeta snakeSkinItemMeta = snakeSkin.getItemMeta();
        snakeSkinItemMeta.setDisplayName(format("&7Snake Skin"));
        snakeSkin.setItemMeta(snakeSkinItemMeta);

        //snakeEye Item
        snakeEye = new ItemStack(Material.BARRIER);
        ItemMeta snakeEyeItemMeta = snakeEye.getItemMeta();
        snakeEyeItemMeta.setDisplayName(format("&7Snake Eye"));
        snakeEye.setItemMeta(snakeEyeItemMeta);

        //softBlueWool Item
        softBlueWool = new ItemStack(Material.BARRIER);
        ItemMeta softBlueWoolItemMeta = softBlueWool.getItemMeta();
        softBlueWoolItemMeta.setDisplayName(format("&7Soft Blue Wool"));
        softBlueWool.setItemMeta(softBlueWoolItemMeta);

        //softGreenWool Item
        softGreenWool = new ItemStack(Material.BARRIER);
        ItemMeta softGreenWoolItemMeta = softGreenWool.getItemMeta();
        softGreenWoolItemMeta.setDisplayName(format("&7Soft Green Wool"));
        softGreenWool.setItemMeta(softGreenWoolItemMeta);

        //softRedWool Item
        softRedWool = new ItemStack(Material.BARRIER);
        ItemMeta softRedWoolItemMeta = softRedWool.getItemMeta();
        softRedWoolItemMeta.setDisplayName(format("&7Soft Red Wool"));
        softRedWool.setItemMeta(softRedWoolItemMeta);

        //softWhiteWool Item
        softWhiteWool = new ItemStack(Material.BARRIER);
        ItemMeta softWhiteWoolItemMeta = softWhiteWool.getItemMeta();
        softWhiteWoolItemMeta.setDisplayName(format("&7Soft White Wool"));
        softWhiteWool.setItemMeta(softWhiteWoolItemMeta);

        //softYellowWool Item
        softYellowWool = new ItemStack(Material.BARRIER);
        ItemMeta softYellowWoolItemMeta = softYellowWool.getItemMeta();
        softYellowWoolItemMeta.setDisplayName(format("&7Soft Yellow Wool"));
        softYellowWool.setItemMeta(softYellowWoolItemMeta);

        //softSand Item
        softSand = new ItemStack(Material.BARRIER);
        ItemMeta softSandItemMeta = softSand.getItemMeta();
        softSandItemMeta.setDisplayName(format("&7Soft Sand"));
        softSand.setItemMeta(softSandItemMeta);

        //softSilk Item
        softSilk = new ItemStack(Material.BARRIER);
        ItemMeta softSilkItemMeta = softSilk.getItemMeta();
        softSilkItemMeta.setDisplayName(format("&7Soft Silk"));
        softSilk.setItemMeta(softSilkItemMeta);

        //smoothSilt Item
        smoothSilt = new ItemStack(Material.BARRIER);
        ItemMeta smoothSiltItemMeta = smoothSilt.getItemMeta();
        smoothSiltItemMeta.setDisplayName(format("&7Smooth Silt"));
        smoothSilt.setItemMeta(smoothSiltItemMeta);

        //slimySkin Item
        slimySkin = new ItemStack(Material.BARRIER);
        ItemMeta slimySkinItemMeta = slimySkin.getItemMeta();
        slimySkinItemMeta.setDisplayName(format("&7Slimy Skin"));
        slimySkin.setItemMeta(slimySkinItemMeta);

        //smokeBomb Item
        smokeBomb = new ItemStack(Material.BARRIER);
        ItemMeta smokeBombItemMeta = smokeBomb.getItemMeta();
        smokeBombItemMeta.setDisplayName(format("&7Smoke Bomb"));
        smokeBomb.setItemMeta(smokeBombItemMeta);

        //silverFeather Item
        silverFeather = new ItemStack(Material.BARRIER);
        ItemMeta silverFeatherItemMeta = silverFeather.getItemMeta();
        silverFeatherItemMeta.setDisplayName(format("&7Silver Feather"));
        silverFeather.setItemMeta(silverFeatherItemMeta);

        //skyFlux Item
        skyFlux = new ItemStack(Material.BARRIER);
        ItemMeta skyFluxItemMeta = skyFlux.getItemMeta();
        skyFluxItemMeta.setDisplayName(format("&7Sky Flux"));
        skyFlux.setItemMeta(skyFluxItemMeta);

        //skyStone Item
        skyStone = new ItemStack(Material.BARRIER);
        ItemMeta skyStoneItemMeta = skyStone.getItemMeta();
        skyStoneItemMeta.setDisplayName(format("&7Sky Stone"));
        skyStone.setItemMeta(skyStoneItemMeta);

        //sharpClaw Item
        sharpClaw = new ItemStack(Material.BARRIER);
        ItemMeta sharpClawItemMeta = sharpClaw.getItemMeta();
        sharpClawItemMeta.setDisplayName(format("&7Sharp Claw"));
        sharpClaw.setItemMeta(sharpClawItemMeta);

        //sharpEdge Item
        sharpEdge = new ItemStack(Material.BARRIER);
        ItemMeta sharpEdgeItemMeta = sharpEdge.getItemMeta();
        sharpEdgeItemMeta.setDisplayName(format("&7Sharp Edge"));
        sharpEdge.setItemMeta(sharpEdgeItemMeta);

        //sharpStone Item
        sharpStone = new ItemStack(Material.BARRIER);
        ItemMeta sharpStoneItemMeta = sharpStone.getItemMeta();
        sharpStoneItemMeta.setDisplayName(format("&7Sharp Stone"));
        sharpStone.setItemMeta(sharpStoneItemMeta);

        //shatteredBlade Item
        shatteredBlade = new ItemStack(Material.BARRIER);
        ItemMeta shatteredBladeItemMeta = shatteredBlade.getItemMeta();
        shatteredBladeItemMeta.setDisplayName(format("&7Shattered Blade"));
        shatteredBlade.setItemMeta(shatteredBladeItemMeta);

        //shimmeringJewel Item
        shimmeringJewel = new ItemStack(Material.BARRIER);
        ItemMeta shimmeringJewelItemMeta = shimmeringJewel.getItemMeta();
        shimmeringJewelItemMeta.setDisplayName(format("&7Shimmering Jewel"));
        shimmeringJewel.setItemMeta(shimmeringJewelItemMeta);

        //shiningWool Item
        shiningWool = new ItemStack(Material.BARRIER);
        ItemMeta shiningWoolItemMeta = shiningWool.getItemMeta();
        shiningWoolItemMeta.setDisplayName(format("&7Shining Wool"));
        shiningWool.setItemMeta(shiningWoolItemMeta);

        //shinyPebble Item
        shinyPebble = new ItemStack(Material.BARRIER);
        ItemMeta shinyPebbleItemMeta = shinyPebble.getItemMeta();
        shinyPebbleItemMeta.setDisplayName(format("&7Shiny Pebble"));
        shinyPebble.setItemMeta(shinyPebbleItemMeta);

        //shreddedBone Item
        shreddedBone = new ItemStack(Material.BARRIER);
        ItemMeta shreddedBoneItemMeta = shreddedBone.getItemMeta();
        shreddedBoneItemMeta.setDisplayName(format("&7Shredded Bone"));
        shreddedBone.setItemMeta(shreddedBoneItemMeta);

        //seaSalt Item
        seaSalt = new ItemStack(Material.BARRIER);
        ItemMeta seaSaltItemMeta = seaSalt.getItemMeta();
        seaSaltItemMeta.setDisplayName(format("&7Sea Salt"));
        seaSalt.setItemMeta(seaSaltItemMeta);

        //seabirdFeather Item
        seabirdFeather = new ItemStack(Material.BARRIER);
        ItemMeta seabirdFeatherItemMeta = seabirdFeather.getItemMeta();
        seabirdFeatherItemMeta.setDisplayName(format("&7Seabird Feather"));
        seabirdFeather.setItemMeta(seabirdFeatherItemMeta);

        //seabirdEgg Item
        seabirdEgg = new ItemStack(Material.BARRIER);
        ItemMeta seabirdEggItemMeta = seabirdEgg.getItemMeta();
        seabirdEggItemMeta.setDisplayName(format("&7Seabird Egg"));
        seabirdEgg.setItemMeta(seabirdEggItemMeta);

        //seaGrass Item
        seaGrass = new ItemStack(Material.BARRIER);
        ItemMeta seaGrassItemMeta = seaGrass.getItemMeta();
        seaGrassItemMeta.setDisplayName(format("&7Sea Grass"));
        seaGrass.setItemMeta(seaGrassItemMeta);

        //serpentTongue Item
        serpentTongue = new ItemStack(Material.BARRIER);
        ItemMeta serpentTongueItemMeta = serpentTongue.getItemMeta();
        serpentTongueItemMeta.setDisplayName(format("&7Serpent Tongue"));
        serpentTongue.setItemMeta(serpentTongueItemMeta);

        //severedHeart Item
        severedHeart = new ItemStack(Material.BARRIER);
        ItemMeta severedHeartItemMeta = severedHeart.getItemMeta();
        severedHeartItemMeta.setDisplayName(format("&7Severed Heart"));
        severedHeart.setItemMeta(severedHeartItemMeta);

        //severedLeg Item
        severedLeg = new ItemStack(Material.BARRIER);
        ItemMeta severedLegItemMeta = severedLeg.getItemMeta();
        severedLegItemMeta.setDisplayName(format("&7Severed Leg"));
        severedLeg.setItemMeta(severedLegItemMeta);

        //rottingLog Item
        rottingLog = new ItemStack(Material.BARRIER);
        ItemMeta rottingLogItemMeta = rottingLog.getItemMeta();
        rottingLogItemMeta.setDisplayName(format("&7Rotting Log"));
        rottingLog.setItemMeta(rottingLogItemMeta);

        //rottingBone Item
        rottingBone = new ItemStack(Material.BARRIER);
        ItemMeta rottingBoneItemMeta = rottingBone.getItemMeta();
        rottingBoneItemMeta.setDisplayName(format("&7Rotting Bone"));
        rottingBone.setItemMeta(rottingBoneItemMeta);

        //royalBlood Item
        royalBlood = new ItemStack(Material.BARRIER);
        ItemMeta royalBloodItemMeta = royalBlood.getItemMeta();
        royalBloodItemMeta.setDisplayName(format("&7Royal Blood"));
        royalBlood.setItemMeta(royalBloodItemMeta);

        //saltWater Item
        saltWater = new ItemStack(Material.BARRIER);
        ItemMeta saltWaterItemMeta = saltWater.getItemMeta();
        saltWaterItemMeta.setDisplayName(format("&7Salt Water"));
        saltWater.setItemMeta(saltWaterItemMeta);

        //salt Item
        salt = new ItemStack(Material.BARRIER);
        ItemMeta saltItemMeta = salt.getItemMeta();
        saltItemMeta.setDisplayName(format("&7Salt"));
        salt.setItemMeta(saltItemMeta);

        //scarabHusk Item
        scarabHusk = new ItemStack(Material.BARRIER);
        ItemMeta scarabHuskItemMeta = scarabHusk.getItemMeta();
        scarabHuskItemMeta.setDisplayName(format("&7Scarab Husk"));
        scarabHusk.setItemMeta(scarabHuskItemMeta);

        //scarredLeather Item
        scarredLeather = new ItemStack(Material.BARRIER);
        ItemMeta scarredLeatherItemMeta = scarredLeather.getItemMeta();
        scarredLeatherItemMeta.setDisplayName(format("&7Scarred Leather"));
        scarredLeather.setItemMeta(scarredLeatherItemMeta);

        //rottenFlesh Item
        rottenFlesh = new ItemStack(Material.BARRIER);
        ItemMeta rottenFleshItemMeta = rottenFlesh.getItemMeta();
        rottenFleshItemMeta.setDisplayName(format("&7Rotten Flesh"));
        rottenFlesh.setItemMeta(rottenFleshItemMeta);

        //rootsOfEternity Item
        rootsOfEternity = new ItemStack(Material.BARRIER);
        ItemMeta rootsOfEternityItemMeta = rootsOfEternity.getItemMeta();
        rootsOfEternityItemMeta.setDisplayName(format("&7Roots Of Eternity"));
        rootsOfEternity.setItemMeta(rootsOfEternityItemMeta);

        //rose Item
        rose = new ItemStack(Material.BARRIER);
        ItemMeta roseItemMeta = rose.getItemMeta();
        roseItemMeta.setDisplayName(format("&7Rose"));
        rose.setItemMeta(roseItemMeta);

        //riverClay Item
        riverClay = new ItemStack(Material.BARRIER);
        ItemMeta riverClayItemMeta = riverClay.getItemMeta();
        riverClayItemMeta.setDisplayName(format("&7River Clay"));
        riverClay.setItemMeta(riverClayItemMeta);

        //ritualCatalyst Item
        ritualCatalyst = new ItemStack(Material.BARRIER);
        ItemMeta ritualCatalystItemMeta = ritualCatalyst.getItemMeta();
        ritualCatalystItemMeta.setDisplayName(format("&7Ritual Catalyst"));
        ritualCatalyst.setItemMeta(ritualCatalystItemMeta);

        //retinalMembrane Item
        retinalMembrane = new ItemStack(Material.BARRIER);
        ItemMeta retinalMembraneItemMeta = retinalMembrane.getItemMeta();
        retinalMembraneItemMeta.setDisplayName(format("&7Retinal Membrane"));
        retinalMembrane.setItemMeta(retinalMembraneItemMeta);

        //retinalBarbs Item
        retinalBarbs = new ItemStack(Material.BARRIER);
        ItemMeta retinalBarbsItemMeta = retinalBarbs.getItemMeta();
        retinalBarbsItemMeta.setDisplayName(format("&7Retinal Barbs"));
        retinalBarbs.setItemMeta(retinalBarbsItemMeta);

        //rigidFin Item
        rigidFin = new ItemStack(Material.BARRIER);
        ItemMeta rigidFinItemMeta = rigidFin.getItemMeta();
        rigidFinItemMeta.setDisplayName(format("&7Rigid Fin"));
        rigidFin.setItemMeta(rigidFinItemMeta);

        //relicOfTheFuture Item
        relicOfTheFuture = new ItemStack(Material.BARRIER);
        ItemMeta relicOfTheFutureItemMeta = relicOfTheFuture.getItemMeta();
        relicOfTheFutureItemMeta.setDisplayName(format("&7Relic Of The Future"));
        relicOfTheFuture.setItemMeta(relicOfTheFutureItemMeta);

        //reinforcedLeather Item
        reinforcedLeather = new ItemStack(Material.BARRIER);
        ItemMeta reinforcedLeatherItemMeta = reinforcedLeather.getItemMeta();
        reinforcedLeatherItemMeta.setDisplayName(format("&7Reinforced Leather"));
        reinforcedLeather.setItemMeta(reinforcedLeatherItemMeta);

        //regenerativeSpike Item
        regenerativeSpike = new ItemStack(Material.BARRIER);
        ItemMeta regenerativeSpikeItemMeta = regenerativeSpike.getItemMeta();
        regenerativeSpikeItemMeta.setDisplayName(format("&7Regenerative Spike"));
        regenerativeSpike.setItemMeta(regenerativeSpikeItemMeta);

        //razorSharpTooth Item
        razorSharpTooth = new ItemStack(Material.BARRIER);
        ItemMeta razorSharpToothItemMeta = razorSharpTooth.getItemMeta();
        razorSharpToothItemMeta.setDisplayName(format("&7Razor Sharp Tooth"));
        razorSharpTooth.setItemMeta(razorSharpToothItemMeta);

        //rabbitCarcase Item
        rabbitCarcase = new ItemStack(Material.BARRIER);
        ItemMeta rabbitCarcaseItemMeta = rabbitCarcase.getItemMeta();
        rabbitCarcaseItemMeta.setDisplayName(format("&7Rabbit Carcase"));
        rabbitCarcase.setItemMeta(rabbitCarcaseItemMeta);

        //ursineClaw Item
        ursineClaw = new ItemStack(Material.BARRIER);
        ItemMeta ursineClawItemMeta = ursineClaw.getItemMeta();
        ursineClawItemMeta.setDisplayName(format("&7Ursine Claw"));
        ursineClaw.setItemMeta(ursineClawItemMeta);

        //zombieBrain Item
        zombieBrain = new ItemStack(Material.BARRIER);
        ItemMeta zombieBrainItemMeta = zombieBrain.getItemMeta();
        zombieBrainItemMeta.setDisplayName(format("&7Zombie Brain"));
        zombieBrain.setItemMeta(zombieBrainItemMeta);

        //soulStone Item
        soulStone = new ItemStack(Material.BARRIER);
        ItemMeta soulStoneItemMeta = soulStone.getItemMeta();
        soulStoneItemMeta.setDisplayName(format("&7Soul Stone"));
        soulStone.setItemMeta(soulStoneItemMeta);

        //sharpeningStone Item
        sharpeningStone = new ItemStack(Material.BARRIER);
        ItemMeta sharpeningStoneItemMeta = sharpeningStone.getItemMeta();
        sharpeningStoneItemMeta.setDisplayName(format("&7Sharpening Stone"));
        sharpeningStone.setItemMeta(sharpeningStoneItemMeta);

        //roastedTissue Item
        roastedTissue = new ItemStack(Material.BARRIER);
        ItemMeta roastedTissueItemMeta = roastedTissue.getItemMeta();
        roastedTissueItemMeta.setDisplayName(format("&7Roasted Tissue"));
        roastedTissue.setItemMeta(roastedTissueItemMeta);

        //quartzCluster Item
        quartzCluster = new ItemStack(Material.BARRIER);
        ItemMeta quartzClusterItemMeta = quartzCluster.getItemMeta();
        quartzClusterItemMeta.setDisplayName(format("&7Quartz Cluster"));
        quartzCluster.setItemMeta(quartzClusterItemMeta);

        //outdatedNewspaper Item
        outdatedNewspaper = new ItemStack(Material.BARRIER);
        ItemMeta outdatedNewspaperItemMeta = outdatedNewspaper.getItemMeta();
        outdatedNewspaperItemMeta.setDisplayName(format("&7Outdated Newspaper"));
        outdatedNewspaper.setItemMeta(outdatedNewspaperItemMeta);

        //novaBloom Item
        novaBloom = new ItemStack(Material.BARRIER);
        ItemMeta novaBloomItemMeta = novaBloom.getItemMeta();
        novaBloomItemMeta.setDisplayName(format("&7Nova Bloom"));
        novaBloom.setItemMeta(novaBloomItemMeta);

        //mysteriousMist Item
        mysteriousMist = new ItemStack(Material.BARRIER);
        ItemMeta mysteriousMistItemMeta = mysteriousMist.getItemMeta();
        mysteriousMistItemMeta.setDisplayName(format("&7Mysterious Mist"));
        mysteriousMist.setItemMeta(mysteriousMistItemMeta);

        //oldTreasure Item
        oldTreasure = new ItemStack(Material.BARRIER);
        ItemMeta oldTreasureItemMeta = oldTreasure.getItemMeta();
        oldTreasureItemMeta.setDisplayName(format("&7Old Treasure"));
        oldTreasure.setItemMeta(oldTreasureItemMeta);

        //royalCake Item
        royalCake = new ItemStack(Material.BARRIER);
        ItemMeta royalCakeItemMeta = royalCake.getItemMeta();
        royalCakeItemMeta.setDisplayName(format("&7Royal Cake"));
        royalCake.setItemMeta(royalCakeItemMeta);

        //purestTear Item
        purestTear = new ItemStack(Material.BARRIER);
        ItemMeta purestTearItemMeta = purestTear.getItemMeta();
        purestTearItemMeta.setDisplayName(format("&7Purest Tear"));
        purestTear.setItemMeta(purestTearItemMeta);

        //pricklyGrass Item
        pricklyGrass = new ItemStack(Material.BARRIER);
        ItemMeta pricklyGrassItemMeta = pricklyGrass.getItemMeta();
        pricklyGrassItemMeta.setDisplayName(format("&7Prickly Grass"));
        pricklyGrass.setItemMeta(pricklyGrassItemMeta);

        //pluckedFeather Item
        pluckedFeather = new ItemStack(Material.BARRIER);
        ItemMeta pluckedFeatherItemMeta = pluckedFeather.getItemMeta();
        pluckedFeatherItemMeta.setDisplayName(format("&7Plucked Feather"));
        pluckedFeather.setItemMeta(pluckedFeatherItemMeta);

        //poisonSac Item
        poisonSac = new ItemStack(Material.BARRIER);
        ItemMeta poisonSacItemMeta = poisonSac.getItemMeta();
        poisonSacItemMeta.setDisplayName(format("&7Poison Sac"));
        poisonSac.setItemMeta(poisonSacItemMeta);

        //pirateBeard Item
        pirateBeard = new ItemStack(Material.BARRIER);
        ItemMeta pirateBeardItemMeta = pirateBeard.getItemMeta();
        pirateBeardItemMeta.setDisplayName(format("&7Pirate Beard"));
        pirateBeard.setItemMeta(pirateBeardItemMeta);

        //pinkWool Item
        pinkWool = new ItemStack(Material.BARRIER);
        ItemMeta pinkWoolItemMeta = pinkWool.getItemMeta();
        pinkWoolItemMeta.setDisplayName(format("&7Pink Wool"));
        pinkWool.setItemMeta(pinkWoolItemMeta);

        //pegasusFeather Item
        pegasusFeather = new ItemStack(Material.BARRIER);
        ItemMeta pegasusFeatherItemMeta = pegasusFeather.getItemMeta();
        pegasusFeatherItemMeta.setDisplayName(format("&7Pegasus Feather"));
        pegasusFeather.setItemMeta(pegasusFeatherItemMeta);

        //pigBlood Item
        pigBlood = new ItemStack(Material.BARRIER);
        ItemMeta pigBloodItemMeta = pigBlood.getItemMeta();
        pigBloodItemMeta.setDisplayName(format("&7Pig Blood"));
        pigBlood.setItemMeta(pigBloodItemMeta);

        //pigmanMeat Item
        pigmanMeat = new ItemStack(Material.BARRIER);
        ItemMeta pigmanMeatItemMeta = pigmanMeat.getItemMeta();
        pigmanMeatItemMeta.setDisplayName(format("&7Pigman Meat"));
        pigmanMeat.setItemMeta(pigmanMeatItemMeta);

        //opticFiber Item
        opticFiber = new ItemStack(Material.BARRIER);
        ItemMeta opticFiberItemMeta = opticFiber.getItemMeta();
        opticFiberItemMeta.setDisplayName(format("&7Optic Fiber"));
        opticFiber.setItemMeta(opticFiberItemMeta);

        //orcEye Item
        orcEye = new ItemStack(Material.BARRIER);
        ItemMeta orcEyeItemMeta = orcEye.getItemMeta();
        orcEyeItemMeta.setDisplayName(format("&7Orc Eye"));
        orcEye.setItemMeta(orcEyeItemMeta);

        //orcSkin Item
        orcSkin = new ItemStack(Material.BARRIER);
        ItemMeta orcSkinItemMeta = orcSkin.getItemMeta();
        orcSkinItemMeta.setDisplayName(format("&7Orc Skin"));
        orcSkin.setItemMeta(orcSkinItemMeta);

        //orkTeeth Item
        orkTeeth = new ItemStack(Material.BARRIER);
        ItemMeta orkTeethItemMeta = orkTeeth.getItemMeta();
        orkTeethItemMeta.setDisplayName(format("&7Ork Teeth"));
        orkTeeth.setItemMeta(orkTeethItemMeta);

        //owlFeather Item
        owlFeather = new ItemStack(Material.BARRIER);
        ItemMeta owlFeatherItemMeta = owlFeather.getItemMeta();
        owlFeatherItemMeta.setDisplayName(format("&7Owl Feather"));
        owlFeather.setItemMeta(owlFeatherItemMeta);

    }
    /*
        Listners for the dungeon loot menu
    */
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        Action action = e.getAction();
        Player player = e.getPlayer();
        ItemStack item = e.getItem();

        if ((action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK))) {
            if (item.getType() == Material.BARREL) {
                e.setCancelled(true);

                Dungeon dungeon = getDungeonOfPlayer(player);

                if (dungeon != null) {
                    Inventory inv = Bukkit.createInventory(null, 36, format("&7DungeonLoot"));

                    // Put the items into the inventory
                    AddItemsToInv(dungeon.getDungeonLoot().getDungeonLoot(), inv);
                    player.sendMessage(String.valueOf(dungeon.getDungeonLoot().getDungeonLoot().size()));

                    //open the inventory to the player
                    player.openInventory(inv);
                }
                else {
                    player.sendMessage(format("&cYou Need To Be In A Dungeon To Open Your Loot Menu"));
                }
            }
        }
    }

    @EventHandler
    public void onInventoryInteract(InventoryInteractEvent e) {
        //if the name of the inventory matches the dungeonLoot menu name it cancels the event
        if (e.getView().getTitle().equals(format("&7DungeonLoot"))) {
            e.setCancelled(true);
        }
    }


    private void AddItemsToInv(ArrayList<ItemStack> dungeonLoot, Inventory inv) {

        for (ItemStack item : dungeonLoot) {
            if (item.getAmount() > item.getMaxStackSize()) {
                int maxStackSize = item.getMaxStackSize();
                int amount = item.getAmount();

                while (amount > 0) {
                    if (amount > maxStackSize) {
                        ItemStack temp = item.clone();
                        temp.setAmount(maxStackSize);
                        inv.addItem(temp);
                        amount -= maxStackSize;
                    }
                    else {
                        ItemStack temp = item.clone();
                        temp.setAmount(amount);
                        inv.addItem(temp);
                        amount = 0;
                    }
                }
            }
            else {
                inv.addItem(item);
            }
        }
    }

    /*
        methods to manipulate the loot list
    */
    public void addGold(int i) {
        int amount = i;
        int ingot = 0;
        int block = 0;
        int liquid = 0;

        if (!(dungeonLoot.isEmpty())) {
            ArrayList<ItemStack> itemsToRemove = new ArrayList<>();
            for (ItemStack item : dungeonLoot) {
                String name = item.getItemMeta().getDisplayName();

                if (name.equals(goldNugget.getItemMeta().getDisplayName())) {
                    amount += item.getAmount();
                    itemsToRemove.add(item);
                    break;
                }
                if (name.equals(gold.getItemMeta().getDisplayName())) {
                    amount += 64 * item.getAmount();
                    itemsToRemove.add(item);
                    break;
                }
                else if (name.equals(goldBlock.getItemMeta().getDisplayName())) {
                    amount += (4096 * item.getAmount());
                    itemsToRemove.add(item);
                    break;
                }
                else if (name.equals(liquidGold.getItemMeta().getDisplayName())) {
                    amount += (262144 * item.getAmount());
                    itemsToRemove.add(item);
                    break;
                }
            }
            if (!(itemsToRemove.isEmpty())) dungeonLoot.removeAll(itemsToRemove);
        }

        if (amount >= 262144) {
            while (amount >= 262144) {
                liquid += 1;
                amount -= 262144;
            }
        }
        if (amount >= 4096) {
            while (amount >= 4096) {
                block += 1;
                amount -= 4096;
            }
        }
        if (amount >= 64) {
            while (amount >= 64) {
                block += ingot;
                amount -= 64;
            }
        }

        //adds the items to the list
        if (liquid > 0) {
            ItemStack liquidGoldToBeAdded = liquidGold.clone();
            liquidGoldToBeAdded.setAmount(liquid);
            dungeonLoot.add(liquidGoldToBeAdded);
        }
        if (block > 0) {
            ItemStack goldBlockToBeAdded = goldBlock.clone();
            goldBlockToBeAdded.setAmount(block);
            dungeonLoot.add(goldBlockToBeAdded);
        }
        if (ingot > 0) {
            ItemStack goldToBeAdded = gold.clone();
            goldToBeAdded.setAmount(amount);
            dungeonLoot.add(goldToBeAdded);
        }
        if (amount > 0) {
            ItemStack goldNuggetsToBeAdded = goldNugget.clone();
            goldNuggetsToBeAdded.setAmount(amount);
            dungeonLoot.add(goldNuggetsToBeAdded);
        }
    }

    /*
        getters
    */
    public ArrayList<ItemStack> getDungeonLoot() {
        return dungeonLoot;
    }

    public ItemStack getItem(MobDrops e) {
        if (e.equals(MobDrops.potato)) return potato;
        else if (e.equals(MobDrops.ratHair)) return ratHair;
        else if (e.equals(MobDrops.rancidFlesh)) return rancidFlesh;
        else if (e.equals(MobDrops.goblinTooth)) return goblinTooth;
        else if (e.equals(MobDrops.yetiFur)) return yetiFur;
        else if (e.equals(MobDrops.woodScrap)) return woodScrap;
        else if (e.equals(MobDrops.viralTentacle)) return viralTentacle;
        else if (e.equals(MobDrops.viscousSlime)) return viscousSlime;
        else if (e.equals(MobDrops.wybelFluff)) return wybelFluff;
        else if (e.equals(MobDrops.wringglingDarkness)) return wringglingDarkness;
        else if (e.equals(MobDrops.wornCoin)) return wornCoin;
        else if (e.equals(MobDrops.woodSnippet)) return woodSnippet;
        else if (e.equals(MobDrops.wool)) return wool;
        else if (e.equals(MobDrops.wolfFang)) return wolfFang;
        else if (e.equals(MobDrops.windOrnament)) return windOrnament;
        else if (e.equals(MobDrops.wendigoBone)) return wendigoBone;
        else if (e.equals(MobDrops.werewolfTail)) return werewolfTail;
        else if (e.equals(MobDrops.branch)) return branch;
        else if (e.equals(MobDrops.warpedSkin)) return warpedSkin;
        else if (e.equals(MobDrops.usedFireball)) return usedFireball;
        else if (e.equals(MobDrops.unsettelingSoul)) return unsettelingSoul;
        else if (e.equals(MobDrops.unmeltableIce)) return unmeltableIce;
        else if (e.equals(MobDrops.undeadHeart)) return undeadHeart;
        else if (e.equals(MobDrops.unicornHorn)) return unicornHorn;
        else if (e.equals(MobDrops.unholySpirit)) return unholySpirit;
        else if (e.equals(MobDrops.thinQuill)) return thinQuill;
        else if (e.equals(MobDrops.thornedTusk)) return thornedTusk;
        else if (e.equals(MobDrops.tornSkin)) return tornSkin;
        else if (e.equals(MobDrops.toughBone)) return toughBone;
        else if (e.equals(MobDrops.toughSkin)) return toughSkin;
        else if (e.equals(MobDrops.toxicLumps)) return toxicLumps;
        else if (e.equals(MobDrops.toxicSpores)) return toxicSpores;
        else if (e.equals(MobDrops.trollHair)) return trollHair;
        else if (e.equals(MobDrops.truffle)) return truffle;
        else if (e.equals(MobDrops.turtleShell)) return turtleShell;
        else if (e.equals(MobDrops.thickVines)) return thickVines;
        else if (e.equals(MobDrops.squidBeak)) return squidBeak;
        else if (e.equals(MobDrops.squidBrain)) return squidBrain;
        else if (e.equals(MobDrops.squidInc)) return squidInc;
        else if (e.equals(MobDrops.stickyFern)) return stickyFern;
        else if (e.equals(MobDrops.stolenGoods)) return stolenGoods;
        else if (e.equals(MobDrops.stolenPearls)) return stolenPearls;
        else if (e.equals(MobDrops.strangeGeode)) return strangeGeode;
        else if (e.equals(MobDrops.stretchedHide)) return stretchedHide;
        else if (e.equals(MobDrops.strongFlesh)) return strongFlesh;
        else if (e.equals(MobDrops.sturdyFlesh)) return sturdyFlesh;
        else if (e.equals(MobDrops.sugarStick)) return sugarStick;
        else if (e.equals(MobDrops.swooperWing)) return swooperWing;
        else if (e.equals(MobDrops.sylphidTears)) return sylphidTears;
        else if (e.equals(MobDrops.tannedFlesh)) return tannedFlesh;
        else if (e.equals(MobDrops.tenderPork)) return tenderPork;
        else if (e.equals(MobDrops.tendonClump)) return tendonClump;
        else if (e.equals(MobDrops.tentacle)) return tentacle;
        else if (e.equals(MobDrops.terracottaChunk)) return terracottaChunk;
        else if (e.equals(MobDrops.thickMud)) return thickMud;
        else if (e.equals(MobDrops.spiderFang)) return spiderFang;
        else if (e.equals(MobDrops.spiderLeg)) return spiderLeg;
        else if (e.equals(MobDrops.soulEssence)) return soulEssence;
        else if (e.equals(MobDrops.soggyStone)) return soggyStone;
        else if (e.equals(MobDrops.spiderEggs)) return spiderEggs;
        else if (e.equals(MobDrops.snakeTooth)) return snakeTooth;
        else if (e.equals(MobDrops.snakeSkin)) return snakeSkin;
        else if (e.equals(MobDrops.snakeEye)) return snakeEye;
        else if (e.equals(MobDrops.softBlueWool)) return softBlueWool;
        else if (e.equals(MobDrops.softGreenWool)) return softGreenWool;
        else if (e.equals(MobDrops.softRedWool)) return softRedWool;
        else if (e.equals(MobDrops.softWhiteWool)) return softWhiteWool;
        else if (e.equals(MobDrops.softYellowWool)) return softYellowWool;
        else if (e.equals(MobDrops.softSand)) return softSand;
        else if (e.equals(MobDrops.softSilk)) return softSilk;
        else if (e.equals(MobDrops.smoothSilt)) return smoothSilt;
        else if (e.equals(MobDrops.slimySkin)) return slimySkin;
        else if (e.equals(MobDrops.smokeBomb)) return smokeBomb;
        else if (e.equals(MobDrops.silverFeather)) return silverFeather;
        else if (e.equals(MobDrops.skyFlux)) return skyFlux;
        else if (e.equals(MobDrops.skyStone)) return skyStone;
        else if (e.equals(MobDrops.sharpClaw)) return sharpClaw;
        else if (e.equals(MobDrops.sharpEdge)) return sharpEdge;
        else if (e.equals(MobDrops.sharpStone)) return sharpStone;
        else if (e.equals(MobDrops.shatteredBlade)) return shatteredBlade;
        else if (e.equals(MobDrops.shimmeringJewel)) return shimmeringJewel;
        else if (e.equals(MobDrops.shiningWool)) return shiningWool;
        else if (e.equals(MobDrops.shinyPebble)) return shinyPebble;
        else if (e.equals(MobDrops.shreddedBone)) return shreddedBone;
        else if (e.equals(MobDrops.seaSalt)) return seaSalt;
        else if (e.equals(MobDrops.seabirdFeather)) return seabirdFeather;
        else if (e.equals(MobDrops.seabirdEgg)) return seabirdEgg;
        else if (e.equals(MobDrops.seaGrass)) return seaGrass;
        else if (e.equals(MobDrops.serpentTongue)) return serpentTongue;
        else if (e.equals(MobDrops.severedHeart)) return severedHeart;
        else if (e.equals(MobDrops.severedLeg)) return severedLeg;
        else if (e.equals(MobDrops.rottingLog)) return rottingLog;
        else if (e.equals(MobDrops.rottingBone)) return rottingBone;
        else if (e.equals(MobDrops.royalBlood)) return royalBlood;
        else if (e.equals(MobDrops.saltWater)) return saltWater;
        else if (e.equals(MobDrops.salt)) return salt;
        else if (e.equals(MobDrops.scarabHusk)) return scarabHusk;
        else if (e.equals(MobDrops.scarredLeather)) return scarredLeather;
        else if (e.equals(MobDrops.rottenFlesh)) return rottenFlesh;
        else if (e.equals(MobDrops.rootsOfEternity)) return rootsOfEternity;
        else if (e.equals(MobDrops.rose)) return rose;
        else if (e.equals(MobDrops.riverClay)) return riverClay;
        else if (e.equals(MobDrops.ritualCatalyst)) return ritualCatalyst;
        else if (e.equals(MobDrops.retinalMembrane)) return retinalMembrane;
        else if (e.equals(MobDrops.retinalBarbs)) return retinalBarbs;
        else if (e.equals(MobDrops.rigidFin)) return rigidFin;
        else if (e.equals(MobDrops.relicOfTheFuture)) return relicOfTheFuture;
        else if (e.equals(MobDrops.reinforcedLeather)) return reinforcedLeather;
        else if (e.equals(MobDrops.regenerativeSpike)) return regenerativeSpike;
        else if (e.equals(MobDrops.razorSharpTooth)) return razorSharpTooth;
        else if (e.equals(MobDrops.rabbitCarcase)) return rabbitCarcase;
        else if (e.equals(MobDrops.ursineClaw)) return ursineClaw;
        else if (e.equals(MobDrops.zombieBrain)) return zombieBrain;
        else if (e.equals(MobDrops.soulStone)) return soulStone;
        else if (e.equals(MobDrops.sharpeningStone)) return sharpeningStone;
        else if (e.equals(MobDrops.roastedTissue)) return roastedTissue;
        else if (e.equals(MobDrops.quartzCluster)) return quartzCluster;
        else if (e.equals(MobDrops.outdatedNewspaper)) return outdatedNewspaper;
        else if (e.equals(MobDrops.novaBloom)) return novaBloom;
        else if (e.equals(MobDrops.mysteriousMist)) return mysteriousMist;
        else if (e.equals(MobDrops.oldTreasure)) return oldTreasure;
        else if (e.equals(MobDrops.royalCake)) return royalCake;
        else if (e.equals(MobDrops.purestTear)) return purestTear;
        else if (e.equals(MobDrops.pricklyGrass)) return pricklyGrass;
        else if (e.equals(MobDrops.pluckedFeather)) return pluckedFeather;
        else if (e.equals(MobDrops.poisonSac)) return poisonSac;
        else if (e.equals(MobDrops.pirateBeard)) return pirateBeard;
        else if (e.equals(MobDrops.pinkWool)) return pinkWool;
        else if (e.equals(MobDrops.pegasusFeather)) return pegasusFeather;
        else if (e.equals(MobDrops.pigBlood)) return pigBlood;
        else if (e.equals(MobDrops.pigmanMeat)) return pigmanMeat;
        else if (e.equals(MobDrops.opticFiber)) return opticFiber;
        else if (e.equals(MobDrops.orcEye)) return orcEye;
        else if (e.equals(MobDrops.orcSkin)) return orcSkin;
        else if (e.equals(MobDrops.orkTeeth)) return orkTeeth;
        else if (e.equals(MobDrops.owlFeather)) return owlFeather;


        return null;
    }



}























