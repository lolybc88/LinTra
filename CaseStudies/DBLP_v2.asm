<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="DBLPv2"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="A.__matchicmt():V"/>
		<constant value="__exec__"/>
		<constant value="icmt"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyicmt(NTransientLink;):V"/>
		<constant value="booktitle"/>
		<constant value="MMM!InProceedings;"/>
		<constant value="0"/>
		<constant value="bootitle"/>
		<constant value="7:62-7:66"/>
		<constant value="7:62-7:75"/>
		<constant value="__matchicmt"/>
		<constant value="Author"/>
		<constant value="MM"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="records"/>
		<constant value="InProceedings"/>
		<constant value="J.oclIsTypeOf(J):J"/>
		<constant value="B.not():B"/>
		<constant value="24"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="J.booktitle():J"/>
		<constant value="ICMT"/>
		<constant value="J.indexOf(J):J"/>
		<constant value="J.&gt;=(J):J"/>
		<constant value="B.or(B):B"/>
		<constant value="57"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="a"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="out"/>
		<constant value="MM1"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="12:18-12:19"/>
		<constant value="12:18-12:27"/>
		<constant value="12:40-12:41"/>
		<constant value="12:54-12:70"/>
		<constant value="12:40-12:71"/>
		<constant value="12:18-12:72"/>
		<constant value="12:86-12:88"/>
		<constant value="12:86-12:100"/>
		<constant value="12:109-12:115"/>
		<constant value="12:86-12:116"/>
		<constant value="12:118-12:119"/>
		<constant value="12:86-12:119"/>
		<constant value="12:18-12:120"/>
		<constant value="14:3-17:4"/>
		<constant value="r"/>
		<constant value="ip"/>
		<constant value="__applyicmt"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="4"/>
		<constant value="36"/>
		<constant value="49"/>
		<constant value="J.size():J"/>
		<constant value="numOfPapers"/>
		<constant value="15:12-15:13"/>
		<constant value="15:12-15:18"/>
		<constant value="15:4-15:18"/>
		<constant value="16:20-16:21"/>
		<constant value="16:20-16:29"/>
		<constant value="16:42-16:43"/>
		<constant value="16:56-16:72"/>
		<constant value="16:42-16:73"/>
		<constant value="16:20-16:74"/>
		<constant value="16:88-16:90"/>
		<constant value="16:88-16:102"/>
		<constant value="16:111-16:117"/>
		<constant value="16:88-16:118"/>
		<constant value="16:120-16:121"/>
		<constant value="16:88-16:121"/>
		<constant value="16:20-16:122"/>
		<constant value="16:20-16:130"/>
		<constant value="16:4-16:130"/>
		<constant value="link"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<pcall arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<pcall arg="10"/>
			<pcall arg="13"/>
			<set arg="3"/>
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="15"/>
			<getasm/>
			<pcall arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<pcall arg="40"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="42"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="44"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="0" name="17" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="46"/>
		<parameters>
		</parameters>
		<code>
			<load arg="47"/>
			<get arg="48"/>
		</code>
		<linenumbertable>
			<lne id="49" begin="0" end="0"/>
			<lne id="50" begin="0" end="1"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="51">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="52"/>
			<push arg="53"/>
			<findme/>
			<push arg="54"/>
			<call arg="55"/>
			<iterate/>
			<store arg="19"/>
			<pushf/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<get arg="56"/>
			<iterate/>
			<store arg="29"/>
			<load arg="29"/>
			<push arg="57"/>
			<push arg="53"/>
			<findme/>
			<call arg="58"/>
			<call arg="59"/>
			<if arg="60"/>
			<load arg="29"/>
			<call arg="61"/>
			<enditerate/>
			<iterate/>
			<store arg="29"/>
			<load arg="29"/>
			<call arg="62"/>
			<push arg="63"/>
			<call arg="64"/>
			<pushi arg="47"/>
			<call arg="65"/>
			<call arg="66"/>
			<enditerate/>
			<call arg="59"/>
			<if arg="67"/>
			<getasm/>
			<get arg="1"/>
			<push arg="68"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<pcall arg="69"/>
			<dup/>
			<push arg="70"/>
			<load arg="19"/>
			<pcall arg="71"/>
			<dup/>
			<push arg="72"/>
			<push arg="52"/>
			<push arg="73"/>
			<new/>
			<pcall arg="74"/>
			<pusht/>
			<pcall arg="75"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="76" begin="11" end="11"/>
			<lne id="77" begin="11" end="12"/>
			<lne id="78" begin="15" end="15"/>
			<lne id="79" begin="16" end="18"/>
			<lne id="80" begin="15" end="19"/>
			<lne id="81" begin="8" end="24"/>
			<lne id="82" begin="27" end="27"/>
			<lne id="83" begin="27" end="28"/>
			<lne id="84" begin="29" end="29"/>
			<lne id="85" begin="27" end="30"/>
			<lne id="86" begin="31" end="31"/>
			<lne id="87" begin="27" end="32"/>
			<lne id="88" begin="7" end="34"/>
			<lne id="89" begin="49" end="54"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="90" begin="14" end="23"/>
			<lve slot="2" name="91" begin="26" end="33"/>
			<lve slot="1" name="70" begin="6" end="56"/>
			<lve slot="0" name="17" begin="0" end="57"/>
		</localvariabletable>
	</operation>
	<operation name="92">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="93"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="70"/>
			<call arg="94"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="72"/>
			<call arg="95"/>
			<store arg="96"/>
			<load arg="96"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<call arg="30"/>
			<set arg="38"/>
			<dup/>
			<getasm/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="29"/>
			<get arg="56"/>
			<iterate/>
			<store arg="97"/>
			<load arg="97"/>
			<push arg="57"/>
			<push arg="53"/>
			<findme/>
			<call arg="58"/>
			<call arg="59"/>
			<if arg="98"/>
			<load arg="97"/>
			<call arg="61"/>
			<enditerate/>
			<iterate/>
			<store arg="97"/>
			<load arg="97"/>
			<call arg="62"/>
			<push arg="63"/>
			<call arg="64"/>
			<pushi arg="47"/>
			<call arg="65"/>
			<call arg="59"/>
			<if arg="99"/>
			<load arg="97"/>
			<call arg="61"/>
			<enditerate/>
			<call arg="100"/>
			<call arg="30"/>
			<set arg="101"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="102" begin="11" end="11"/>
			<lne id="103" begin="11" end="12"/>
			<lne id="104" begin="9" end="14"/>
			<lne id="105" begin="23" end="23"/>
			<lne id="106" begin="23" end="24"/>
			<lne id="107" begin="27" end="27"/>
			<lne id="108" begin="28" end="30"/>
			<lne id="109" begin="27" end="31"/>
			<lne id="110" begin="20" end="36"/>
			<lne id="111" begin="39" end="39"/>
			<lne id="112" begin="39" end="40"/>
			<lne id="113" begin="41" end="41"/>
			<lne id="114" begin="39" end="42"/>
			<lne id="115" begin="43" end="43"/>
			<lne id="116" begin="39" end="44"/>
			<lne id="117" begin="17" end="49"/>
			<lne id="118" begin="17" end="50"/>
			<lne id="119" begin="15" end="52"/>
			<lne id="89" begin="8" end="53"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="4" name="90" begin="26" end="35"/>
			<lve slot="4" name="91" begin="38" end="48"/>
			<lve slot="3" name="72" begin="7" end="53"/>
			<lve slot="2" name="70" begin="3" end="53"/>
			<lve slot="0" name="17" begin="0" end="53"/>
			<lve slot="1" name="120" begin="0" end="53"/>
		</localvariabletable>
	</operation>
</asm>
