func void b_initarmor ()
{
	self.aivar[aiv_lasttarget] = npc_getequippedarmor(self); //member array item assignment
};

func c_npc hlp_getnpc (var int instancename) { }; //custom return type

instance fa_enemy_prehit_24 (c_fightai)
{
	move[0] = move_strafe; //array item assignment
};

prototype mst_default_blackgobbo(c_npc)
{
	name = "czarny goblin";
};

const int value_z�hne =	 10; //german char in identifier

class c_npc
{
	var int guild, level; //list of variables in single declaration
}

instance blackgobbomace	(mst_default_blackgobbo)
{
	set_blackgobbo_visuals(); //function call in instance definition
}

prototype npc_default (c_npc)
{
	npc_settalentvalue	(self, npc_talent_1h, 0); //function call in prototype definition
};

func void org_801_lares_bringlistanteil_info()
{
	gorn.aivar[aiv_findable]==true; // expression as statement (programmer mistake)
};

func void foo()
{
    if (Thorus_MordragKo == LOG_RUNNING)
    {

    }
    else if (Thorus_MordragKo == LOG_FAILED)
    {

    } //no semicolon!

    if (Wld_IsFPAvailable (self, "SHOP"))
    {
        AI_GotoFP (self,"SHOP");
    } //no semicolon!

    PrintDebugInt	(PD_ZS_DETAIL, "bodystate", bodystate&(BS_MAX|BS_FLAG_INTERRUPTABLE|BS_FLAG_FREEHANDS)); //complex expression as argument
}

const STRING spellFXInstanceNames[MAX_SPELL] = { "Light", "Fireball" }; //array literal

CLASS C_FightAI
{
	VAR INT move[MAX_MOVE]; // var array
};

const func PLAYER_PERC_ASSESSMAGIC = B_AssessMagic; // func constant

INSTANCE self,other (C_NPC); //multiple names in instance declaration

const int	HAI_DIST_ABORT_MELEE 			= HAI_DIST_MELEE+400; // expression in const value