package com.example.cheolmin.lolwikipedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String EXTRA_ITEM = "item";



    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    //private SectionsPagerAdapter mSectionsPagerAdapter;
    private ArrayList<Champion> champions;
    private ArrayList<Item> items;
    public static final String EXTRA_CHAMP = "msg";

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);


        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        //initialize champions & items arraylist
        champions = new ArrayList<>();
        items = new ArrayList<>();
        fillItemList();
        fillChampionList();


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        // mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        // mViewPager = (ViewPager) findViewById(R.id.container);
        //mViewPager.setAdapter(mSectionsPagerAdapter);

        //TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        //mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position   , long id) {
                Champion champion = champions.get(position);
                //TODO put the whole Champion object as an extra to pass to the new activity

                Intent champ = new Intent(MainActivity.this, Main2Activity.class);
                //String keyIdentifier = null;
                //champ.putExtra(EXTRA_MESSAGE, keyIdentifier);


                Champion champion1 = new Champion(champions.get(position).getName(), champions.get(position).getDescription(), champions.get(position).getItem1(), champions.get(position).getItem2(), champions.get(position).getItem3(), champions.get(position).getItem4(), champions.get(position).getItem5(), champions.get(position).getItem6(), champions.get(position).getImageid());
                Champion champion2 = champions.get(position);
                Item item1 = champions.get(position).getItem1();
                Item item2 = champions.get(position).getItem2();
                Item item3 = champions.get(position).getItem3();
                Item item4 = champions.get(position).getItem4();
                Item item5 = champions.get(position).getItem5();
                Item item6 = champions.get(position).getItem6();

                Log.d("STUFF", "onItemClick: "+item1 + ""+item2 + "" + item3 +" "+ item4+""+item5+" "+item6+"" + champion2 + " " + position);
                Log.d("STUFF", "onItemClick: " + champions +  " " + items);

                //
                //champion1.setDescription("dd");

                //champion1.setName("Amumu");

                champ.putExtra(EXTRA_MESSAGE, champion2);
                champ.putExtra(EXTRA_ITEM, item1);
                champ.putExtra(EXTRA_ITEM, item2);
                champ.putExtra(EXTRA_ITEM, item3);
                champ.putExtra(EXTRA_ITEM, item4);
                champ.putExtra(EXTRA_ITEM, item5);
                champ.putExtra(EXTRA_ITEM, item6);


                //champ.putExtra(EXTRA_MESSAGE, keyIdentifier);
                startActivity(champ);
                //champion1.setItems(//call item array list?);



                //put extra to new activity and make only one acitivity.
                //use position to differentitate between other champions clicks and send extra
            }
        });

    }

    private void fillItemList() {
        items.add(0, new Item("Abyssal Mask", R.drawable.abyssalmask));
        items.add(1, new Item("Adaptive Helm", R.drawable.adaptivehelm));
        items.add(2, new Item("Ardent Censer", R.drawable.ardentcenser));
        items.add(3, new Item("Banner of Command", R.drawable.bannerofcommand));
        items.add(4, new Item("Banshee's Veil", R.drawable.bansheesveil));
        items.add(5, new Item("Berserker's Greaves", R.drawable.berserkersgreaves));
        items.add(6, new Item("Boots of Swiftness", R.drawable.bootsofswiftness));
        items.add(7, new Item("Blade of the Ruined King", R.drawable.bladeoftheruinedking));
        items.add(8, new Item("Corrupting Potion", R.drawable.corruptingpotion));
        items.add(9, new Item("Cull", R.drawable.cull));
        items.add(10, new Item("Dead Man's Plate", R.drawable.deadmansplate));
        items.add(11, new Item("Death's Dance", R.drawable.deathsdance));
        items.add(12, new Item("Dusk Blade of Draktharr", R.drawable.duskbladeofdraktharr));
        items.add(13, new Item("Edge of Night", R.drawable.edgeofnightitem));
        items.add(14, new Item("Elixir of Iron", R.drawable.elixirofiron));
        items.add(15, new Item("Elixir of Sorcery", R.drawable.elixirofsorcery));
        items.add(16, new Item("Elixir of Wrath", R.drawable.elixirofwrath));
        items.add(17, new Item("Essence cereaver", R.drawable.essencereaver));
        items.add(18, new Item("Eye of the Oasis", R.drawable.eyeoftheoasis));
        items.add(19, new Item("Face of the Mountain", R.drawable.faceofthemountain));
        items.add(20, new Item("Farsight alteration", R.drawable.farsightalteration));
        items.add(21, new Item("Frost Queen's Claim", R.drawable.frostqueensclaim));
        items.add(22, new Item("Frozen Heart", R.drawable.frozenheart));
        items.add(23, new Item("Frozen Mallet", R.drawable.frozenmalletitem));
        items.add(24, new Item("Gargoyle Stone Plate", R.drawable.gargoylestoneplate));
        items.add(25, new Item("Guardian's Angel", R.drawable.guardianangel));
        items.add(26, new Item("Guinsoo's Rage Blade", R.drawable.guinsoosrageblade));
        items.add(27, new Item("Health Potion", R.drawable.healthpotion));
        items.add(28, new Item("Hextech GLP 800", R.drawable.hextechglp800));
        items.add(29, new Item("Hextech Gunblade", R.drawable.hextechgunblade));
        items.add(30, new Item("Hextech Protobelt 01", R.drawable.hextechprotobelt01));
        items.add(31, new Item("Hunters Potion", R.drawable.hunterspotion));
        items.add(32, new Item("Ice Born Gauntlet", R.drawable.iceborngauntlet));
        items.add(33, new Item("Ionian Boots of Flucidity", R.drawable.ionianbootsoflucidity));
        items.add(34, new Item("Knights Vow", R.drawable.knightsvow));
        items.add(35, new Item("Liandry's Torment", R.drawable.liandrystorment));
        items.add(36, new Item("Lich Bane", R.drawable.lichbane));
        items.add(37, new Item("Locket of the Iron Solari", R.drawable.locketoftheironsolari));
        items.add(38, new Item("Lord Dominiks Regards", R.drawable.lorddominiksregards));
        items.add(39, new Item("Luden's Echo", R.drawable.ludensecho));
        items.add(40, new Item("Manamune", R.drawable.manamune));
        items.add(41, new Item("Maw of Malmortius", R.drawable.mawofmalmortius));
        items.add(42, new Item("Mejai's Soul Stealer", R.drawable.mejaissoulstealer));
        items.add(43, new Item("Mercurys Streads", R.drawable.mercurystreads));
        items.add(44, new Item("Mikael's Crucible", R.drawable.mikaelscrucible));
        items.add(45, new Item("Morellonomicon", R.drawable.morellonomicon));
        items.add(46, new Item("Mortal Reminder", R.drawable.mortalreminder));
        items.add(47, new Item("Muramana", R.drawable.muramana));
        items.add(48, new Item("Nashor's Tooth", R.drawable.nashorstooth));
        items.add(49, new Item("Ninja Tabi", R.drawable.ninjatabi));
        items.add(50, new Item("Ohmwrecker", R.drawable.ohmwrecker));
        items.add(51, new Item("Oracle Alteration", R.drawable.oraclealteration));
        items.add(52, new Item("Phantom Dancer", R.drawable.phantomdancer));
        items.add(53, new Item("Rabadon's Death Cap", R.drawable.rabadonsdeathcap));
        items.add(54, new Item("Randuin's Omen", R.drawable.randuinsomen));
        items.add(55, new Item("Rapid Fire Cannon", R.drawable.rapidfirecannon));
        items.add(56, new Item("Ravenous Hydra", R.drawable.ravenoushydra));
        items.add(57, new Item("Redemption", R.drawable.redemption));
        items.add(58, new Item("Refillable Potion", R.drawable.refillablepotion));
        items.add(59, new Item("Righteous Glory", R.drawable.righteousglory));
        items.add(60, new Item("Rod of Ages", R.drawable.rodofages));
        items.add(61, new Item("Ruby Sight Stone", R.drawable.rubysightstone));
        items.add(62, new Item("Runaan's Hurricance", R.drawable.runaanshurricane));
        items.add(63, new Item("Rylai's Crystal Scepter", R.drawable.rylaiscrystalscepter));
        items.add(64, new Item("Serpah's Embrace", R.drawable.seraphsembrace));
        items.add(65, new Item("Sight Stone", R.drawable.sightstone));
        items.add(66, new Item("Skirmisher's  Sabre Cinder Hulk", R.drawable.skirmisherssabrecinderhulk));
        items.add(67, new Item("Skirmisher's  Sabre Blood Razor", R.drawable.skirmisherssabrebloodrazor));
        items.add(68, new Item("Skirmisher's  Sabre Ruinc Echoe's", R.drawable.skirmisherssabrerunicechoes));
        items.add(69, new Item("Skirmisher's  SabreKing Warrior", R.drawable.skirmisherssabrewarrior));
        items.add(70, new Item("Sorcerers Shoes", R.drawable.sorcerersshoes));
        items.add(71, new Item("Spririt Visage", R.drawable.spiritvisageitem));
        items.add(72, new Item("Stalkers Blade Blood Razor", R.drawable.stalkersbladebloodrazor));
        items.add(73, new Item("Stalkers Blade Cinder Hulk", R.drawable.stalkersbladecinderhulk));
        items.add(74, new Item("Stalkers Blade Ruinc Echoe's", R.drawable.stalkersbladerunicechoes));
        items.add(75, new Item("Stalkers Blade Warrior", R.drawable.stalkersbladewarrior));
        items.add(76, new Item("Statik Shiv", R.drawable.statikkshiv));
        items.add(77, new Item("Sterak's Gage", R.drawable.steraksgage));
        items.add(78, new Item("Stinger", R.drawable.stinger));
        items.add(79, new Item("Sun Fire Cape", R.drawable.sunfirecape));
        items.add(80, new Item("Sweeping Lens", R.drawable.sweepinglens));
        items.add(81, new Item("Talisman of Ascension", R.drawable.talismanofascension));
        items.add(82, new Item("The Black Cleaver", R.drawable.theblackcleaver));
        items.add(83, new Item("The Blood Thirster", R.drawable.thebloodthirster));
        items.add(84, new Item("Thornmail", R.drawable.thornmail));
        items.add(85, new Item("Titanichydra", R.drawable.titanichydra));
        items.add(86, new Item("Tracker's Knife Blood Razor", R.drawable.trackersknifebloodrazor));
        items.add(87, new Item("Tracker's Knife Cinder Hulk", R.drawable.trackersknifecinderhulkitem));
        items.add(88, new Item("Tracker's Knife Runic Echoe's", R.drawable.trackerskniferunicechoes));
        items.add(89, new Item("Tracker's Knife Warrior", R.drawable.trackersknifewarrior));
        items.add(90, new Item("Trinity Force", R.drawable.trinityforce));
        items.add(91, new Item("Void Staff", R.drawable.voidstaff));
        items.add(92, new Item("Warmog's Armor", R.drawable.warmogsarmor));
        items.add(93, new Item("Wit's End", R.drawable.witsend));
        items.add(94, new Item("Yomumu's Ghost Blade", R.drawable.youmuusghostblade));
        items.add(95, new Item("Zeke's Convergence", R.drawable.zekesconvergence));
        items.add(96, new Item("Zhonya's", R.drawable.zhonyashourglass));
        items.add(97, new Item("Zzrot Portal", R.drawable.zzrotportal));
        items.add(98, new Item("Boots of Mobility", R.drawable.bootsofmobility));
        items.add(99, new Item("Infinity Edge", R.drawable.infinityedge));









    }

    private void fillChampionList() {
        champions.add(0, new Champion("Aatrox", "The Darkin Blade", items.get(43), items.get(7),items.get(26),items.get(82),items.get(10),items.get(71), R.drawable.aatroxsquare));
        champions.add(1, new Champion("Ahri", "The Nine-Tailed Fox", items.get(70),items.get(45),items.get(91),items.get(53),items.get(30),items.get(96), R.drawable.ahrisquare));
        champions.add(2, new Champion("Akali", "The Fist of Shadow", items.get(70), items.get(29), items.get(96), items.get(63), items.get(35), items.get(91), R.drawable.akalisquare));
        champions.add(3, new Champion("Alistar", "The Minotaur", items.get(98), items.get(19), items.get(61), items.get(57), items.get(34), items.get(24), R.drawable.alistarsquare));
        champions.add(4, new Champion("Amumu", "The Sad Mummy", items.get(49), items.get(73), items.get(35), items.get(0), items.get(92), items.get(84), R.drawable.amumusquare));
        champions.add(5, new Champion("Anivia", "The Cryophoenix", items.get(70), items.get(64), items.get(60), items.get(53), items.get(91), items.get(35), R.drawable.aniviasquare));
        champions.add(6, new Champion("Annie", "The Dark Child", items.get(70), items.get(39), items.get(53), items.get(91), items.get(36), items.get(96), R.drawable.anniesquare));
        champions.add(7, new Champion("Ashe", "The Frost Archer", items.get(5), items.get(99), items.get(62), items.get(52), items.get(38), items.get(25), R.drawable.ashesquare));
        champions.add(8, new Champion("Aurelion Sol", "The Star Forger", items.get(6), items.get(28), items.get(63), items.get(96), items.get(53), items.get(4), R.drawable.aurelionsolsquare));
        champions.add(9, new Champion("Azir", "The Emporer of the Sands", items.get(5), items.get(48), items.get(63), items.get(53), items.get(96), items.get(4), R.drawable.azirsquare));
        champions.add(10, new Champion("Bard", "The Wandering Caretaker", items.get(98), items.get(57), items.get(37), items.get(18), items.get(44), items.get(22), R.drawable.bardsquare));
        champions.add(11, new Champion("Blitzcrank", "The Great Steam Golem", items.get(98), items.get(19), items.get(22), items.get(34), items.get(57), items.get(61), R.drawable.blitzcranksquare));
        champions.add(12, new Champion("Brand", "The Burning Vengeance", items.get(70), items.get(63), items.get(35), items.get(53), items.get(96), items.get(96), R.drawable.brandsquare));
        champions.add(13, new Champion("Braum", "The Heart of the Freljord", items.get(98), items.get(61), items.get(37), items.get(34), items.get(19), items.get(95), R.drawable.braumsquare));
        champions.add(14, new Champion("Caitlyn", "The Sheriff of Piltover", items.get(5), items.get(99), items.get(76), items.get(55), items.get(38), items.get(83), R.drawable.caitlynsquare));
        champions.add(15, new Champion("Camille", "The Steel Shadow", items.get(49), items.get(56), items.get(90), items.get(94), items.get(23), items.get(25), R.drawable.camillesquare));
        champions.add(16, new Champion("Cassiopeia", "The Serpent's Embrace", items.get(64), items.get(45), items.get(4), items.get(53), items.get(96), items.get(60), R.drawable.cassiopeiasquare));
        champions.add(17, new Champion("Cho'gath", "The Terror of the Void", items.get(70), items.get(30), items.get(39), items.get(35), items.get(96), items.get(92),R.drawable.chogathsquare));
        champions.add(18, new Champion("Corki", "THe Daring Bombardier", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.corkisquare));
        champions.add(19, new Champion("Darius", "The Hand of Noxus", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.dariussquare));
        champions.add(20, new Champion("Diana", "Scorn of the Moon", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.dianasquare));
        champions.add(21, new Champion("Draven", "The Madman of Zaun", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.dravensquare));
        champions.add(22, new Champion("Dr. Mundo", "The Glorious Executioner", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.drmundosquare));
        champions.add(23, new Champion("Ekko", "The Boy Who Shattered Time", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.ekkosquare));
        champions.add(24, new Champion("Elise", "The Spider Queen", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.elisesquare));
        champions.add(25, new Champion("Evelynn", "Agony's Embrace", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.evelynnsquare));
        champions.add(26, new Champion("Ezreal", "The Prodigal Explorer", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.ezrealsquare));
        champions.add(27, new Champion("Fiddle Stick", "The Harbinger of Doom", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.fiddlestickssquare));
        champions.add(28, new Champion("Fiora", "The Grand Duelist", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.fiorasquare));
        champions.add(29, new Champion("Fizz", "The Tidal Trickster", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.fizzsquare));
        champions.add(30, new Champion("Galio", "The Colosus", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.galiosquare));
        champions.add(31, new Champion("Gangplank", "The Saltwater Scourge", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.gangplanksquare));
        champions.add(32, new Champion("Garen", "The Might of Demacia", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.garensquare));
        champions.add(33, new Champion("Gnar", "THe Missing Link", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.gnarsquare));
        champions.add(34, new Champion("Gragas", "The Rabble Rouser", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.gragassquare));
        champions.add(35, new Champion("Graves", "The Outlaw", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.gravessquare));
        champions.add(36, new Champion("Hecarim", "The Shadow of War", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.hecarimsquare));
        champions.add(37, new Champion("Heimerdinger", "The Revered Inventor", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.heimerdingersquare));
        champions.add(38, new Champion("Illaoi", "The Kraken Priestess", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.illaoisquare));
        champions.add(39, new Champion("Irellia", "The Will of the Blades", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.ireliasquare));
        champions.add(40, new Champion("Ivern", "The Green Father", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.ivernsquare));
        champions.add(41, new Champion("Janna", "The Storm's Fury", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.jannasquare));
        champions.add(42, new Champion("Jarvan IV", "The Eemplar of Demacia", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.jarvanivsquare));
        champions.add(43, new Champion("Jax", "Grandmaster of Arms", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.jaxsquare));
        champions.add(44, new Champion("Jayce", "The Defender of Tomorrow", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.jaycesquare));
        champions.add(45, new Champion("Jhin", "The Virtuoso", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.jhinsquare));
        champions.add(46, new Champion("Jinx", "The Loose Cannon", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.jinxsquare));
        champions.add(47, new Champion("Kalista", "The Spear of Vengeance", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.kalistasquare));
        champions.add(48, new Champion("Karma", "The Enlightened One", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.karmasquare));
        champions.add(49, new Champion("Karthus", "The Deathsinger", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.karthussquare));
        champions.add(50, new Champion("Kassadin", "The Void Walker", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.kassadinsquare));
        champions.add(51, new Champion("Katarina", "The Sinister Blade", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.katarinasquare));
        champions.add(52, new Champion("Kayle", "The Judicator", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.kaylesquare));
        champions.add(53, new Champion("Kayn", "THe Shadow Reaper", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.kaynsquare));
        champions.add(54, new Champion("Kennen", "The Heart of the Tempest", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.kennensquare));
        champions.add(55, new Champion("Kha'zix", "The Voidreaver", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.khazixsquare));
        champions.add(56, new Champion("Kindred", "The Eternal Hunters", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.kindredsquare));
        champions.add(57, new Champion("Kled", "The Cantankerous Cavalier", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.kledsquare));
        champions.add(58, new Champion("Kog'maw", "The Mouth of the Abyss", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.kogmawsquare));
        champions.add(59, new Champion("Leblanc", "The Deceiver", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.leblancsquare));
        champions.add(60, new Champion("Lee Sin", "The Blind Monk", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.leesinsquare));
        champions.add(61, new Champion("Leona", "The Radiant Dawn", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.leonasquare));
        champions.add(62, new Champion("Lissandra", "The Ice Witch", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.lissandrasquare));
        champions.add(63, new Champion("Lucian", "The Purifier", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.luciansquare));
        champions.add(64, new Champion("Lulu", "Tbe Fae Sorceress", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.lulusquare));
        champions.add(65, new Champion("Lux", "The Lady of Luminosity", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.luxsquare));
        champions.add(66, new Champion("Malphite", "Sard of the Monolith", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.malphitesquare));
        champions.add(67, new Champion("Malzahar", "The Prophet of the Void", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.malzaharsquare));
        champions.add(68, new Champion("Maokai", "The Twisted Treant", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.maokaisquare));
        champions.add(69, new Champion("Master Yi", "The Wuju Bladesman", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.masteryisquare));
        champions.add(70, new Champion("Miss Fortune", "The Bounty Hunter", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.missfortunesquare));
        champions.add(71, new Champion("Mordekaiser", "The Iron Revenant", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.mordekaisersquare));
        champions.add(72, new Champion("Morgana", "Fallen Angel", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.mordekaisersquare));
        champions.add(73, new Champion("Nami", "The Tidecaller", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.namisquare));
        champions.add(74, new Champion("Nasus", "The Curator of the Sands", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.nasussquare));
        champions.add(75, new Champion("Nautilus", "The Titan of the Depths", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.nautilussquare));
        champions.add(76, new Champion("Nidalee", "The Bestial Huntress", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.nidaleesquare));
        champions.add(77, new Champion("Nocturne", "The Eternal Nightmare", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.nocturnesquare));
        champions.add(78, new Champion("Nunu", "The Yeti Nightmare", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.nunusquare));
        champions.add(79, new Champion("Olaf", "The Berserker", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.olafsquare));
        champions.add(80, new Champion("Oriana", "The Lady of Clockwork", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.oriannasquare));
        champions.add(81, new Champion("Ornn", "The Fire below the Mountain", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.ornnsquare));
        champions.add(82, new Champion("Pantheon", "The Artisan of War", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.pantheonsquare));
        champions.add(83, new Champion("Poppy", "Keeper of the Hammer", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.poppysquare));
        champions.add(84, new Champion("Quinn", "Demacia's Wings", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.quinnsquare));
        champions.add(85, new Champion("Rakan", "The Charmer", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.rakansquare));
        champions.add(86, new Champion("Rammus", "The Armordillo", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.rammussquare));
        champions.add(87, new Champion("Rek'sai", "The Void Burrower", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.reksaisquare));
        champions.add(88, new Champion("Renekton", "The Butcher of the Sands", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.renektonsquare));
        champions.add(89, new Champion("Rengar", "The Pridestalker", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.rengarsquare));
        champions.add(90, new Champion("Riven", "The Exile", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.rivensquare));
        champions.add(91, new Champion("Rumble", "The Mechanized Menaced", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.rumblesquare));
        champions.add(92, new Champion("Ryze", "The Rune Mage", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.ryzesquare));
        champions.add(93, new Champion("Sejuani", "Fury of the North", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.sejuanisquare));
        champions.add(94, new Champion("Shaco", "The Demon Jestor", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.shacosquare));
        champions.add(95, new Champion("Shen", "The Eye of Twilight", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.shensquare));
        champions.add(96, new Champion("Shyvanna", "The Half-Dragon", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.shyvanasquare));
        champions.add(97, new Champion("Singed", "The Mad Chemist", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.singedsquare));
        champions.add(98, new Champion("Sion", "The Undead Juggernaut", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.sionsquare));
        champions.add(99, new Champion("Sivir", "The Battle Mistress", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.sivirsquare));
        champions.add(100, new Champion("Skarner", "The Crystal Vanguard", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.skarnersquare));
        champions.add(101, new Champion("Sona", "Maven of the Strings", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.sonasquare));
        champions.add(102, new Champion("Soraka", "The Starchild", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.sorakasquare));
        champions.add(103, new Champion("Swain", "The Master Tactician", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.swainsquare));
        champions.add(104, new Champion("Syndra", "The Dark Soverign", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.syndrasquare));
        champions.add(105, new Champion("Tahm Kench", "The River King", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.tahmkenchsquare));
        champions.add(106, new Champion("Taliyah", "The Stoneweaver", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.taliyahsquare));
        champions.add(107, new Champion("Talon", "The Blade's Shadow", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.talonsquare));
        champions.add(108, new Champion("Taric", "The Shield of Valoran", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.taricsquare));
        champions.add(109, new Champion("Teemo", "The Swift Scout", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.teemosquare));
        champions.add(110, new Champion("Thresh", "The Chain Warden", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.threshsquare));
        champions.add(111, new Champion("Tristana", "The Yordle Gunner", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.tristanasquare));
        champions.add(112, new Champion("Trundle", "The Troll King", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.trundlesquare));
        champions.add(113, new Champion("Tryndamere", "The Barbarian King", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.tryndameresquare));
        champions.add(114, new Champion("Twisted Fate", "The Card Master", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.twistedfatesquare));
        champions.add(115, new Champion("Twitch", "The Plague Rat", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.twitchsquare));
        champions.add(116, new Champion("Udyr", "The Spirit Walker", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.udyrsquare));
        champions.add(117, new Champion("Urgot", "The Dreadnought", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.urgotsquare));
        champions.add(118, new Champion("Varus", "The Arrow of Retribution", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.varussquare));
        champions.add(119, new Champion("Vayne", "The Night Hunter", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.vaynesquare));
        champions.add(120, new Champion("Veigar", "The Tiny Master of Evil", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.veigarsquare));
        champions.add(121, new Champion("Vel'koz", "The Eye of the Void", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.velkozsquare));
        champions.add(122, new Champion("Viktor", "The Piltover Enforcer", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.viktorsquare));
        champions.add(123, new Champion("Vi", "The Machine Herald", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.viktorsquare));
        champions.add(124, new Champion("Vladimir", "The Crimson Reaper", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.vladimirsquare));
        champions.add(125, new Champion("Volibear", "The Thunder's Roar", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.volibearsquare));
        champions.add(126, new Champion("Warwick", "The Uncaged Wrath of Zaun", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.warmogsarmor));
        champions.add(127, new Champion("Wukong", "The Monkey King", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.wukongsquare));
        champions.add(128, new Champion("Xayah", "The Rebel", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.xayahsquare));
        champions.add(129, new Champion("Xerath", "The Magus Ascendant", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.xerathsquare));
        champions.add(130, new Champion("Xin Zhao", "The Seneschal of Demacia", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.xinzhaosquare));
        champions.add(131, new Champion("Yasuo", "The Unforgiven", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.yasuosquare));
        champions.add(132, new Champion("Yorick", "Shepherd of Souls", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.yoricksquare));
        champions.add(133, new Champion("Zac", "The Secret Weapon", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.zacsquare));
        champions.add(134, new Champion("Zed", "The Master of Shadows", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.zedsquare));
        champions.add(135, new Champion("Ziggs", "The Hexplosives Expert", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.ziggssquare));
        champions.add(136, new Champion("Zilean", "THe Chronokeeper", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.zileansquare));
        champions.add(137, new Champion("Zyra", "Rise of the Thorns", items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), items.get(0), R.drawable.zyrasquare));
    }


    //champions.add(new Champion("Amumu"));



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
//    private static class PlaceholderFragment extends Fragment {
//        /**
//         * The fragment argument representing the section number for this
//         * fragment.
//         */
//        private static final String ARG_SECTION_NUMBER = "section_number";
//
//        public PlaceholderFragment() {
//        }
//
//        /**
//         * Returns a new instance of this fragment for the given section
//         * number.
//         */
//        public static PlaceholderFragment newInstance(int sectionNumber) {
//            PlaceholderFragment fragment = new PlaceholderFragment();
//            Bundle args = new Bundle();
//            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
//            return rootView;
//        }
//    }
//
//    /**
//     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
//     * one of the sections/tabs/pages.
//     */
//    private class SectionsPagerAdapter extends FragmentPagerAdapter {
//
//        public SectionsPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            switch (position) {
//                case 0:
//                    Tab1 tab1 = new Tab1();
//                    return tab1;
//                case 1:
//                    Tab2 tab2 = new Tab2();
//                    return tab2;
//                case 2:
//                    Tab3 tab3 = new Tab3();
//                    return tab3;
//                case 3:
//                    Tab4 tab4 = new Tab4();
//                    return tab4;
//
//            }
//            return null;
//        }
//
//        @Override
//        public int getCount() {
//            // Show 4 total pages.
//            return 4;
//        }
//    }
}

