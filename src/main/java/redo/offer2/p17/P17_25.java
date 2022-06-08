package redo.offer2.p17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.concurrent.ConcurrentCharInputReader;

/**  
 * @ClassName: P17_25  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月19日  
 *  
 */
public class P17_25 {

    static//

    class Solution {

        int maxArea;
        List<String> ans = null;
        int maxLen = 0;

        public String[] maxRectangle(String[] words) {
            TreeMap<Integer, Set<String>> lenlistMap =
                new TreeMap<>((a, b) -> Integer.compare(b, a));
            TrieNode root = new TrieNode('\0');

            for (String str : words) {
                add(lenlistMap, str);
                add(root, str);
                maxLen = Math.max(maxLen, str.length());
            }

            lenlistMap.forEach((len, set) -> {
                if (len * maxLen <= maxArea) {
                    return;
                }
                TrieNode[] trieNodes = new TrieNode[len];
                Arrays.fill(trieNodes, root);
                backtrack(trieNodes, new ArrayList<>(), set, len);
            });

            return ans.toArray(new String[0]);
        }

        public void backtrack(TrieNode[] trieNodes, List<String> list,
            Set<String> words, int len) {

            if (list.size() != 0
                && list.size() * list.get(0).length() > maxArea) {
                maxArea = list.size() * list.get(0).length();
                ans = new ArrayList<>(list);
            }

            if (len * len <= maxArea || list.size() == len)
                return;

            nextWord:
            for (String word : words) {
                TrieNode[] next = Arrays.copyOf(trieNodes, trieNodes.length);
                for (int i = 0; i < word.length(); ++i) {
                    int chIndex = word.charAt(i) - 'a';
                    if (next[i].children[chIndex] == null) {
                        continue nextWord;
                    }
                    next[i] = next[i].children[chIndex];
                }
                list.add(word);
                backtrack(next, list, words, maxLen);
                list.remove(list.size() - 1);
            }

        }

        void add(Map<Integer, Set<String>> listMap, String str) {
            listMap.computeIfAbsent(str.length(), (x) -> new HashSet<>())
                .add(str);
        }

        void add(TrieNode root, String str) {
            int index = 0;
            while (index < str.length()) {
                char ch = str.charAt(index++);
                if (root.children[ch - 'a'] == null) {
                    root.children[ch - 'a'] = new TrieNode(ch);
                }
                root = root.children[ch - 'a'];
            }
            root.isWord = true;
        }

        static class TrieNode {
            char ch;
            TrieNode[] children = new TrieNode[26];
            boolean isWord = false;

            TrieNode(char ch) {
                this.ch = ch;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        s.maxRectangle(new String[] {
            "cwsmqtaausjakauhujlpgjwpapsyunylpivxzbbdkxfxmeoypt", "n", "gd",
            "ib", "zj", "uw", "fg", "nr", "qp", "fb", "vq", "gz", "un", "tl",
            "gn", "bshvfxaadfogxjjgmjuwijdcpnluaztzyyzhwkkpsznvilhhcc", "bg",
            "zb", "qc", "rs", "jj",
            "khkxfuyqkfmrmqnxkbokatfkaplbdallpjdryysfrqbjuzatqf", "ju", "iq",
            "hx", "zkvygirllpckgxwctgiyzbcuffnqolmbghvzaejzpqckrmjzwu", "aj",
            "mn", "ad", "oa", "kr", "bs", "mh", "pe", "ce", "xn", "jc", "ha",
            "zk", "gf", "xw", "ku", "ll", "fn", "ii", "gw", "yu", "up", "xh",
            "lo", "bsjsjppqxtqwrsxeyamophripgayjuzupkbqmkqmeqjkilcubh", "ne",
            "z", "bv", "ja", "rv", "lh", "dq", "ve", "jk", "qu", "zw", "lw",
            "aw", "rm", "bb", "xi", "rq", "zt", "js", "xu", "kw", "ro", "sf",
            "by", "gb", "mu", "jz", "gi",
            "boquvjhgadilhsbxhjtlmmutmnuttxugmhafppojfgbxghabuy", "yp", "lg",
            "cu", "ct", "mw", "xk", "sl", "zf", "eh", "so", "sp", "kp", "qz",
            "ty", "dy", "dz", "jt", "ey", "yt", "ih",
            "iwdggfxtdgklqpxdsarqexjbgepkdbkmnvdzbmdudhpjbngdxp", "hf", "mx",
            "uouzqwjkwdzvqfdhzpfvzpeajfkvtxdkcrwhvbqbhlqshyaybh", "ef", "ir",
            "adktqiniltegtvohcunbbxwzpmypkgodihutzinwiufbegevqc", "bh", "dm",
            "fk", "uk", "ae", "nm", "qk",
            "toilgaddlgxypkpvfpkctfyiudjcbjpfedgjmvsfrenrvroxdi", "ao",
            "bthhjsqqrqjubfivllsydjmmwpjlymynhqpofwlayzxwksicuu",
            "tjecqwbnfgnpqaqkfkyailypqaubuqwcmhjimphfazbroagzyb", "xr", "gs",
            "r", "rn", "oiikbjjpjngxprbkkerocamygvghxwxboyxafyumexsyycsfcu",
            "sm", "ij", "fj", "ta", "fe", "ox", "rz", "cg", "vv", "cz", "pv",
            "uj", "em", "rl", "uv", "vy",
            "yzvaqlpeuafqfrgdxnsrtsizleobksnijtrvhcvjxzrvvwhlzj", "wl", "nu",
            "io", "bm", "lmkrzmfvhaidusnztyjdxchgthqabzerrnbysboyauwuiqgnrj",
            "pp", "whqplhrluofemarlwgvonyoivmkhaaugqfgifdpxyufaiikqaq", "cb",
            "ri", "ym", "lu",
            "pcgamtwwpqyokvdzimjmeompemhxewwjjmhywfinsjmmrrmnbi",
            "ncqfjjreumidraarkycprwzkdudpzkecyzkcyaxuuvhnfjfrtn", "to", "mr",
            "bycjuhplzcjrscepphwcccalrosgonyzgexlojtshileqceyyt", "sn", "xp",
            "kf", "ul", "pb", "iv", "ea", "ap", "su", "th", "kg",
            "ysukcysqdilqemxikiqynsifdeiblrvznedfrlalmzczqywmqv", "lj", "xz",
            "ra", "fo", "iy", "mm", "zu",
            "pwjpjxirlqswexleoeotuqudzpseowuqjihmbfmlepgquixppa", "ya", "dg",
            "lktvueuukxahguvplyocaoyqspfqvwgmrznztlaefxspicorpe", "dw",
            "nbznkghfiljhsvuiznshnzwkpuukikbzeyeuqrmthdrkncmjiv", "vr", "jh",
            "ly", "co", "bt", "bl", "wv", "er", "wd", "ye", "mi", "ny", "hy",
            "nz", "ip", "wk", "hn",
            "asaplbgmfnfaycpddojdcliwvuylsoiefsmkaazjzherdjbxus", "tr", "st",
            "sa", "ke", "ee", "wh", "px", "ws", "ng",
            "qflxhbcepgukmlsyeneiuvagdnpyallkepgniutddpkrhpsecr", "jl", "cy",
            "av", "pt", "hj", "rk", "kd", "gx", "kk",
            "esfpdztmjtnbglsslxvwkyrkrhwybbwhataverbwkqghupczvo", "qv", "vo",
            "xc", "gr", "ml", "uf", "hq",
            "hdhqghtxfhmrmdpmzdaylngtgoqznqaztchfanvumqdraxeixq", "ak", "bz",
            "yk", "rpuwhkpibuypilyabjnqnekaptlypkgxozbjvozptessyyvicr", "lb",
            "yx", "gqovsmbldqwfyroyyweeukudtxikqatyauguorjvgzrppjydtl", "da",
            "dn", "du", "atsbxpvmjtcernkghoznhgvslekssoigjnneooveoruaqgyytn",
            "qg", "li", "py", "tw", "dj", "if", "ns", "eq", "ni", "si", "tx",
            "as", "at", "sy", "jx", "in", "mp",
            "uzlwwhtvmfilekqrliftjgnqxnjrnsltcywobftyfsaxiazlqz", "xf",
            "zsnuzoiqeezwujyngvppjofnksppakejmlgrbknlpqhckeungv", "ux", "uu",
            "jhxynhixxbrrkufmtxdjikkevrvntsgngttgudondepizpnikd", "rf", "pj",
            "rc", "m", "nh", "zs", "am", "jd", "wg", "ms", "bw", "kx", "ka",
            "yn", "tg", "gj", "fi",
            "krstgziiqabggvvufvuszmsyiiaxdwzawrbozbrvafuefoglqs", "te", "aa",
            "jg", "nf", "yw", "yq", "zm", "nt", "en",
            "rucggdxdkynxyvkhvbyanotbtqbfzpzyavzbkahjgpfjllzyef", "d", "kj",
            "elhfspkxdxqnpmpkdcgmosmglcdcgvqwbrxfzmlaurtvaythjk", "kq", "vc",
            "ho", "wj", "xq", "ic", "ev", "wy", "tc",
            "fooqakmfhzcsotjjkozdbijsoetdwqiktlisrstduwlnmksslh", "uz", "el",
            "hw", "gp", "np", "ph", "be", "dd", "mo", "lc", "va", "tq", "vl",
            "ln", "az", "tz",
            "dkidytafkhhlbmdhzkgqmcvctbafroiitafzwoyoohkzhhikie", "v", "xx",
            "jf", "rfzndcdrshuillnjwrttsorsjqemazazpeifkoecqkvewbtbth", "us",
            "cj", "mv", "fl", "qj", "ck", "bk", "s", "ls", "wo",
            "htfmmbnstvtfixgolzkebgjxdtimcvnjiddkzokkuoebptxhuo", "rw", "mz",
            "vu", "it", "wn", "hz",
            "xmgsracbzttbwqpiwpflflhvmcjedvnrwxxptjbifdstrpipwv", "wm", "yb",
            "tu", "cd", "ds", "bu", "db",
            "gadtwqkazgwellbnmhirhcknahqxeiqgmdgumtujnkedlufyjs",
            "vlmqrilyscywjlytqzvogakjypnksnhhmovdgikqcbjtfescug", "t", "nc",
            "yr", "ch", "i", "rd", "eb", "pq", "xy", "do", "hu", "c",
            "kjxhwupoxpqtcgafzyxmceippseyqwowdgxacppmwljsreiqwk", "k", "vb",
            "df", "sq", "ou", "pc", "tn", "yg", "eg", "wt", "je", "mt", "vi",
            "ob", "wu", "os",
            "atlqerdjdszzmyqwutkcixujbnymgpjrssmadscnxokzbvalge", "ac", "xo",
            "cm", "za", "im", "gu",
            "jnwpdxbterxxgqsifspvhtjkrrjrzsbkmkjpbxgtvxghaeovem", "nb", "hp",
            "fhguuzpuricbknarvfvuuaiqjuoneprtedxhokkoomnpyzrffk", "ze", "oc",
            "xb", "o", "hc", "yy", "qw", "hv", "sc", "bx", "ci", "ax", "sx",
            "uh", "au", "ut", "ld", "y", "x", "eu", "kn", "go", "pz", "hk",
            "nl", "po", "mc",
            "ivhfelbyrrdjtxtdilqhhxpwyeuusgrrewzggafnkwqxdhwqnp",
            "lfprlmqoqyaidlggysrjvraskrfaihsvnlojvcxdkxwqsujmmc", "b", "aq",
            "ti", "ar", "vqtrekspbphuhdjmvbrbrsbjnwxwefsaujonueezvgsgwshctk",
            "jdjikdnrfuynqdenupurxwwxvdrenuwznduourgrkfzwxsucob", "p",
            "hjzxxhlvpmrdcgomiaydnmmkqyrawxhczldrdmqhzzmslpfzvz", "dr", "vs",
            "cv", "zg", "on", "yf", "pa",
            "gupimkaxzmfktkzdctinmhlimdfcxhipsmdoluodlbvkyhcmki",
            "flbabfhawdaqlwvpcstuikgcjkdqknfcmopnqtvpussgflmeqb", "f", "oy",
            "sr", "reoukvhpfgzkdsimjuifwmyrybmwmuoavkfdsijwlugjhyfimd",
            "xsqxmaanlrljzihrgpguewkbqksrzhgkonlbfpmudiubernymq",
            "kveomwtmyfyfnucdcphwqfmmmifhibnbogbwzazulbqbstbrzk", "h", "or",
            "tk", "xm", "ex", "og", "lt", "q", "e",
            "ykypmlotoztrgvwnpxuzhvawbkterpdbjcmtbamvgeahgzdgsq", "xa", "na",
            "zp", "qa", "ru", "sd", "gv",
            "zupodigekkqqpzxzgqvzziejimhrbokysmuhsafjpjbwktnuhl",
            "jjutatmjaydqkppqzmlvpgqpuowfkdqblyipivdvmzjrtskdlu", "iz", "yd",
            "sk", "vk", "rx", "hg", "gk", "hr",
            "ekciqajslpdscierruoyuguajljprqvtknplayirfsdjqfpidw", "om", "ub",
            "xd", "km", "ez", "he", "dx", "ig", "id", "pd",
            "qhegnofrraudcxwzdfxmheaersybvxpgocgsazukleuvafpmuj", "wa", "qt",
            "cw", "no", "lp", "wb", "ql",
            "yzkahsewrhfriyjbbuwnaaglygppsstpqfgifsfeakptocpsfj", "wi", "iu",
            "bo", "ge", "gh", "cf", "wf",
            "qemoqpltvoneqrgrmtouakbuonlcnfmfmheuicsasqwhmorwvf", "gm", "ie",
            "rh", "a", "pi",
            "rkilafbvqwenffovvgebfpnqdtqjxfqtmygaimsrxratvuqqxk", "nd", "pu",
            "vz", "uo", "rb", "fs",
            "yoprekcfrmetsdrkjinmhhdpkmcqmvtgkaqknvbpcbhgmsqehe",
            "opekcclbtawwhvemtmstzalhfkjhxbavgagjmlgwhqktcoosst", "bf",
            "wzsymzwxkbkgjxziqhxezkfyfmlmtcaphqxmfdlucocftlgkdj", "ud", "fq",
            "ur", "vd", "nq",
            "nzavtdsdxafxrihxsuaxnkcslohgevipbqivtpmiipaprvukfp", "fr", "bi",
            "obcrtojfysapvcpmfpchrypkvcwbfszaoivkbaoruftxblklmj", "zd", "oe",
            "nw", "dh", "yc", "jo",
            "vkgsqujvizliryrtqbugstjizernuxctirsvcfeqdkvlwpvsad", "jr", "br",
            "samdncvzklkbpqpkitzikypiiumlahfwsjacywxxidckgqnfgc", "ok", "fv",
            "rj", "ed", "qx", "oz", "bq",
            "fhlpatrkdqzpvcedjrjdutdcurwiencuimpkkjtcjwkoqtlpep", "uc", "tb",
            "ts", "es", "vg", "lx", "lv", "oi", "tt", "zr", "zo",
            "eriudaxijfznacglrhtxyyhkdhqzqqpcnofyrsddmioknzlerm", "jm", "jb",
            "od", "hm", "qy",
            "klmzkhdjqkvibelzkgzjdxzqeqznfpmerbezfhofbpsxuxqzrw", "ua", "vm",
            "mk", "hb", "zy", "pm", "iw", "dc", "la", "vp", "zl",
            "lqkylbwdmirzskccrhfwspqrpqbwedwgrjixgyiqtelguguepv",
            "zxhaiovtaskhvywxxxsvkwqujfmknklpondzwovuhwnszwkrvn", "jv", "fm",
            "ps", "wz", "jq", "sv", "vh", "nv",
            "pqovwnffwqsgdhnsckeqmbuhdlqwpkglwqbpbsrkxpfbanitsm", "ia", "jy",
            "vw", "lz", "nj", "uq", "hs", "wp", "qf", "se", "qe", "ab", "yi",
            "hhblsevefjnqeekzdyjuvubhifusxmqqngpcssobiabmjevvkp", "dp",
            "dfedkaivixvydogxxiqftbpzjesmjtilwitumfpxrjpmllymwe", "vf", "ol",
            "qn", "sw", "bc", "oq", "ky", "il", "tv", "xj", "zz", "eo", "vt",
            "bd", "md", "xg",
            "copaksgibhlhkpqxsugbseomulcglhkvgidgecmnemtfqcxcqb", "zq", "fp",
            "ff", "yv", "qo", "tm", "kv",
            "eqmjuybpsfxmbypqeovnmuhqsslparumvkvkrzkgomvgoanalt", "yj", "et",
            "adzxwpqbkythwjrjeqnjxtfiviyscvbymxquwhnkmjbwocxkzu", "pr", "lm",
            "lf", "ue", "xe", "lq", "kb", "kl", "ba", "cc", "nk", "nx", "sz",
            "jn", "ei", "nn", "uy", "an", "hi", "yz", "fa", "zi", "xt", "ji",
            "yh", "xl", "qm", "cr", "yl", "mq", "rt", "pl", "cp", "cs", "fz",
            "ug", "lr", "zikimyhqdalrwsxgagetoaofqlvmjlomwpkrnzurpmswuylhaq",
            "dqkswyrkfhjmezwxqvqwkbqjgqjfnwmmxrbfglmkmjbdzuzcsa", "oo", "lk",
            "tf", "pg", "cl", "yo", "ww", "vj", "u", "le", "ca", "kh", "gg",
            "mvgkxfembpprqvyantbskhbycclvnwmeskguxlmeceqraqpbci", "gq", "qb",
            "jw", "kc", "ej", "bp", "qq", "ov", "fh", "we", "vn", "jp", "ah",
            "me", "fx", "cx", "l", "ko", "wr", "tj",
            "fdrgfycjxzruwaanmyhaohwlfypvmkpqxzknhbpwbnwyhghzls", "mg", "my",
            "ziuibvhguhwziomtxbleugfaigpgmduvhfdxbvvvgeoagxsllp", "ai",
            "tbqtjiwwqftmhwwvauzzicybdvulksastulcquuokpqerpgqje", "gc", "zv",
            "taxyfiiyapfnqaifvahxmsgcorihsildysshgbxucxmogouwtl",
            "tfgeigfqowcgnoxyutsnsrymkoshyeeuzvluujkuiotpjopqgj",
            "bycdykpmtsryetqzsblkjfzuxwczpthgyclhlxhcmpevnrnmhp", "dl", "qi",
            "oh", "ht", "wx", "is", "sg", "wq", "ix", "of", "pk", "sh",
            "zwbenudxmnnseibttpybkxmakarngnkoeqdeifaxvfebaospkx", "zc", "hd",
            "bj", "hh", "vtzizanfmdkxklnuxloiqvsqplivyyvxvcpnucyoxedlacatwe",
            "gy", "ot", "oj", "fy", "pn", "mj", "dk", "vx", "fc", "pw", "kz",
            "ss", "ys", "ow", "ec", "al", "cq", "xv", "de", "zh", "w", "zn",
            "mb", "ay", "ek", "td",
            "cbnvjoixfeuupomhqjjktmfmfaawxkrveqvpvjkrdlptyellac", "kt", "qh",
            "fd", "ft", "ma", "qd", "dt", "wc", "zx",
            "szsuhmftaarehqcnsmtxnciptadokmohhguizcbxmuihxajnou", "rg", "ew",
            "qr", "rr", "ndqobdpgnjahrnaorbgrubqxpgiabnxwkymjvpgezlvsnvyxpe",
            "re", "tp", "ag", "ki", "pf", "gl", "ks", "fw", "gt", "ep", "j",
            "ga", "tvberqlfknpumimdglrjhoaocuyabqtznoewsderntuvdcpymd",
            "swbdzkzikrulrmxpiaukijfxlvrxmwdojsudqftfzlwehkeddd", "rp", "sb",
            "di", "um", "fu", "hl",
            "djgbkaciyeracnpljhpqhjbpdlqcdfhovlhaignnaihbfuiskr", "dv", "op",
            "g", "ui", "ry", "sj", "ik", "bn", "af", "mf", "cn", "xs", "qs"});
    }

}
