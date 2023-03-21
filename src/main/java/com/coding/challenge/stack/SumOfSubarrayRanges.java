package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class SumOfSubarrayRanges {
	SumOfSubarrayRanges() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 2, 3 };
		assert subArrayRanges(numsOne) == 4;

		final int[] numsTwo = { 1, 3, 3 };
		assert subArrayRanges(numsTwo) == 4;

		final int[] numsThree = { 4, -2, -3, 4, 1 };
		assert subArrayRanges(numsThree) == 59;

		final int[] numsFour = { -947387276, 121576429, 962535263, -901537108, -547304520, -671278529, -988623002,
				936617030, -821291027, 707459969, -408914713, 609381167, 830428370, 87627850, -281755005, 849021313,
				-673543467, 5624517, 891393869, -18084175, 717495833, 742351674, 740749315, -528981621, 604449597,
				-540693281, 159630291, -293166705, 350706461, -769859659, -980391278, 59950071, -973895281, 316210294,
				-304798290, -543119640, 9656435, 807159407, 842791379, 655101032, -961451558, 951881927, -784427088,
				-397826900, 817411166, -640618844, -19300587, 419319870, 724345786, 87032731, -675969791, -924481146,
				-988978605, -463222781, 193702215, -308668317, 576369451, 834458756, 657917023, 981732675, 777278390,
				-509943980, 313304905, -99903720, -668661038, -68082778, -640007754, -100324049, 540124796, -353240400,
				798208565, -527931053, -334677420, -273225447, 712711068, -436965793, -709177288, 387117344, 706608126,
				380664690, 846999252, 203201316, -500232197, 277421478, 420554250, 276391802, -147991846, -474860505,
				-962294079, 39768304, 602861229, 128075727, 684897995, 851805134, 33395686, -336479126, 899489764,
				-867133531, -873008455, -374274741, -360451160, -453826766, -627917865, 309785840, -400936818,
				-843080034, 913069891, -142089805, 55575471, -645082484, 363545816, 138522612, -692356152, 584020123,
				-49648154, -481232287, 97137010, -764046396, 331934782, 180956281, 426956484, 979068650, 218704090,
				-266268073, -776879629, -687976081, -103004260, 689213393, 280660012, 803320222, -195291576, 310029483,
				-547963900, -405950050, -473557612, 84741934, 309837364, -561394273, -578910207, -218147123, -968280534,
				124793599, -352054129, 395393782, 209173886, -448974453, 649869840, -563788087, -678618464, -747597896,
				327984575, 837689751, 990086058, 767291641, -99767408, -283684492, 754914956, -874800967, 642970385,
				142681424, -509403749, -774087094, 925433713, 727944323, 217450946, 816205495, 731734149, 32075426,
				-684698458, -782143435, 104252414, 683561075, 13437855, 788916272, -994484679, 783482037, 776339340,
				251353467, -579361974, -589533882, 506490269, 984065189, 495611347, -213745519, -775320883, -384591980,
				703833354, 413617176, -300520939, -70712846, -880932633, 3732790, 822865019, 142200166, -349685,
				215487862, 487395712, 835833531, -994572082, -126675947, 68183086, 231533396, -935069668, -59973553,
				-447395279, -186027409, 205414184, -352558993, 602818094, 779373157, 398601875, -786401030, -975404146,
				-955076658, -830738487, 342590594, 486064711, -922421207, 35273934, -991543646, -705376783, 998482119,
				-460135977, 317602416, 12421966, 612395857, -299019010, 877630484, 412620141, -756476074, -265790216,
				427768949, 720892540, -62946805, 17615929, 438731380, -355155238, 68600806, -57885795, -280540156,
				-199967011, 40717472, -447784440, 581612563, -221687455, 270473766, -433247585, 473549085, 162773701,
				5444377, 465289573, 150008500, -486673374, -548919475, -850587335, 485043154, 256334562, -674518391,
				117171012, -321501469, 427123385, 362598115, -681391091, 785232888, 825812077, 941695811, 26737652,
				-140791769, -828350474, 152859950, -378857119, -882153008, 415394870, 45673234, 242971921, 94903709,
				-361635725, 297662907, -18962934, -438861178, -478499146, -405700313, -280449714, -141846697,
				-795417916, 96365053, 1431736, -253090785, -891020580, 18035114, -609214902, 399519696, -546239933,
				-596709536, -230814114, -87957146, 711558457, -707143172, -518846561, 189464019, 455924197, 879349476,
				-315316070, 93717381, -7665131, -252700823, 351457139, 128302884, -852175149, 13583416, 915110265,
				768417110, 339438400, 179324224, -720033702, 75768439, -743222007, 198024166, -837279788, 136805943,
				-111682398, -902059269, 623009730, -624979364, -650959080, 851667967, 867735585, 919225989, 139150834,
				-775514253, 84105168, -161028468, -884460287, -57774342, -877687625, 974517701, -669645188, 262365423,
				-76157856, 868526345, 597649538, -5679461, 342932750, 933885033, -956783040, -228525074, -581974300,
				125970482, -803730373, -493334393, 61120594, -73612547, 571307339, -531470720, 708977236, 467386239,
				280860949, 432432073, 686895490, 419655520, -935019117, -776690608, 942271661, -432980190, 661102298,
				-677999069, -877839304, -958114275, 143929461, 682720537, 344696781, -525061050, -47581665, -157659401,
				135963174, 830273552, 572960087, 901938518, -741018882, 245242434, -94789680, -451594748, 930058377,
				456623128, -323997264, 794790547, -31709191, 436918830, 365134849, 260695552, 345931888, -834702555,
				527557203, -858175087, -849586804, 688432460, -960012380, -964949622, 858219396, 432118969, 297310876,
				-440753403, 374733901, 982979960, -203057221, -422370440, 676090359, 8614068, -138865935, -492162463,
				73590667, -503921914, -662645183, 754735862, 45923242, -734242638, -990011115, -590324761, -102953076,
				-79806328, 412140986, -580098036, -612551018, -48597763, -586178488, -897098559, -157521952, -51027135,
				-639510180, 394452993, 510922481, -466720970, -822298549, -891375440, -41353470, -632047103, -200632043,
				-71122137, -813397295, 96277020, -302050622, 152056130, 821130769, 183692066, 698991698, -785512786,
				197593887, 485692225, 655535385, -148958708, -70415434, -125036600, -79666651, 582550720, -536392869,
				-599627132, -205811635, 15051749, 985785935, 588878446, 113684545, 494019949, -225256530, -402786225,
				896487086, 203175248, 585156844, -628745242, 785383137, 277427798, 835075541, -297436540, -24120081,
				497148304, -395146543, 538973697, -549219413, 466316443, -298480796, -243692321, -502534624, -17303726,
				-142258102, -437345776, 564833127, 846806845, 477705109, 617092470, -959851470, 740548642, -210336296,
				-723499750, -688894024, -831695143, 791045837, -833134689, 774126252, -864053110, 32817794, -766024839,
				-831483592, -868683665, 734216049, -968379631, -15124475, -719824120, -210437452, 636377691, 453763858,
				-789752444, -80952426, 757046692, -868318300, -81733616, 554700444, 453802397, 988305775, 930616806,
				-993954982, -799335970, -5650507, 819363843, 867922483, 279464191, 287005808, -361642010, -845232390,
				535328295, -486529187, 18356127, 420737567, 316584031, 650183690, 773263882, 185366639, -851975215,
				109720, 884950379, 971044377, 700978530, -532014874, 912838462, -1061755, 593283308, -367714937,
				575505153, 714945038, 382424858, -777107702, 956864051, -973301099, -367582788, 808978483, -292327915,
				-131921971, -28047564, -288610100, 784888223, -331116741, -66570005, -470250880, 662249257, -338189677,
				-232398428, -710671249, 256966679, 669558162 };
		assert subArrayRanges(numsFour) == 311568064904104l;
	}

	static long subArrayRanges(int[] nums) {
		return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
	}

	static long sumSubarrayMins(int[] arr) {
		final int n = arr.length;
		final long[] minSum = new long[n];
		// monotonically increasing stack.
		final Deque<Integer> s = new ArrayDeque<>();
		long sum = 0;
		for (int i = 0; i < n; i++) {
			while (!s.isEmpty() && arr[s.peek()] > arr[i])
				s.pop();
			if (s.isEmpty())
				minSum[i] = (long) arr[i] * (i + 1);
			else
				minSum[i] = minSum[s.peek()] + (i - s.peek()) * (long) arr[i];

			sum = sum + minSum[i];
			s.push(i);
		}
		return sum;
	}

	static long sumSubarrayMaxs(int[] arr) {
		final int n = arr.length;
		final long[] maxSum = new long[n];
		// monotonically decreasing stack.
		final Deque<Integer> s = new ArrayDeque<>();
		long sum = 0;
		for (int i = 0; i < n; i++) {
			while (!s.isEmpty() && arr[s.peek()] < arr[i])
				s.pop();
			if (s.isEmpty())
				maxSum[i] = (long) arr[i] * (i + 1);
			else
				maxSum[i] = maxSum[s.peek()] + (i - s.peek()) * (long) arr[i];

			sum = sum + maxSum[i];
			s.push(i);
		}
		return sum;
	}
}
