package org.supersymmetry.simple.sum;

import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

public class PFactory2 extends PFactory{

	
	@Test
	public void doTest(){
		
		Variable v1 = new Variable("v1");
		Variable v2 = new Variable("v2");
		Variable v3 = new Variable("v3");
		Variable v4 = new Variable("v4");
		Variable v5 = new Variable("v5");
		Variable v6 = new Variable("v6");
		Variable v7 = new Variable("v7");
		Variable v8 = new Variable("v8");
		Variable v9 = new Variable("v9");
		Variable v10 = new Variable("v10");
		Variable v11 = new Variable("v11");
		Variable v12 = new Variable("v12");
		Variable v13 = new Variable("v13");
		Variable v14 = new Variable("v14");
		Variable v15 = new Variable("v15");
		Variable v16 = new Variable("v16");
		Variable v17 = new Variable("v17");
		Variable v18 = new Variable("v18");
		Variable v19 = new Variable("v19");
		Variable v20 = new Variable("v20");
		Variable v21 = new Variable("v21");
		Variable v22 = new Variable("v22");
		Variable v23 = new Variable("v23");
		Variable v24 = new Variable("v24");
		Variable v25 = new Variable("v25");
		Variable v26 = new Variable("v26");
		Variable v27 = new Variable("v27");
		Variable v28 = new Variable("v28");
		Variable v29 = new Variable("v29");
		Variable v30 = new Variable("v30");
		Variable v31 = new Variable("v31");
		Variable v32 = new Variable("v32");
		Variable v33 = new Variable("v33");
		Variable v34 = new Variable("v34");
		Variable v35 = new Variable("v35");
		Variable v36 = new Variable("v36");
		Variable v37 = new Variable("v37");
		Variable v38 = new Variable("v38");
		Variable v39 = new Variable("v39");
		Variable v40 = new Variable("v40");
		Variable v41 = new Variable("v41");
		Variable v42 = new Variable("v42");
		Variable v43 = new Variable("v43");
		Variable v44 = new Variable("v44");
		Variable v45 = new Variable("v45");
		Conditional a1 =  createConditional (v14,v28,v42,v1,v12,v30,v2,v24,v25,v4,v43,v13,v5,v9,v21,v33,v35,v45,v10,v27,v29,v31,v37,v38,v3,v11,v20,v26,v36,v44);
		Conditional a2 =  createConditional (v2,v4,v17,v26,v35,v37,v45,v15,v36,v27,v28,v33,v41,v43,v1,v10,v32,v39,v44,v13,v21,v38,v9,v12,v30,v19,v42);
		Conditional a3 =  createConditional (v4,v15,v19,v28,v33,v22,v25,v30,v31,v41,v42,v2,v17,v20,v26,v27,v13,v36,v6,v14,v38,v8,v39,v18,v3,v10,v24);
		Conditional a4 =  createConditional (v12,v13,v14,v16,v19,v8,v9,v4,v7,v37,v42,v1,v2,v34,v41,v44,v5,v23,v27,v3,v6,v22,v45,v33,v38,v40);
		Conditional a5 =  createConditional (v6,v15,v17,v24,v27,v32,v41,v7,v18,v20,v22,v1,v3,v25,v28,v35,v37,v39,v42,v45,v33,v36,v8,v11,v2,v13);
		Conditional a6 =  createConditional (v16,v18,v20,v22,v1,v3,v7,v17,v30,v14,v29,v36,v37,v24,v5,v41,v43,v45,v44,v13,v23,v32,v8,v10,v2,v39);
		Conditional a7 =  createConditional (v11,v14,v15,v26,v32,v18,v43,v13,v27,v33,v38,v1,v21,v6,v16,v19,v40,v41,v3,v10,v37,v20,v9,v28,v29,v35,v36);
		Conditional a8 =  createConditional (v5,v18,v21,v23,v34,v45,v39,v41,v44,v1,v2,v7,v13,v26,v31,v17,v24,v29,v43,v3,v4,v28,v35,v40,v42,v9,v11,v32);
		Conditional a9 =  createConditional (v4,v8,v15,v32,v9,v11,v42,v2,v30,v38,v3,v19,v34,v43,v1,v10,v20,v44,v29,v45,v18,v14,v23,v24,v35,v13,v16,v28);
		Conditional a10 =  createConditional (v5,v15,v25,v35,v39,v40,v17,v20,v30,v38,v1,v9,v14,v18,v19,v24,v29,v2,v10,v21,v6,v36,v26,v31,v42,v7,v12);
		Conditional a11 =  createConditional (v26,v5,v7,v11,v12,v14,v3,v16,v45,v35,v10,v30,v39,v1,v13,v25,v28,v34,v8,v21,v29,v4,v44,v22,v24,v6,v15,v18);
		Conditional a12 =  createConditional (v3,v7,v9,v15,v17,v38,v44,v10,v27,v16,v19,v11,v20,v25,v32,v33,v2,v4,v21,v40,v18,v22,v30,v43,v6,v8,v23);
		Conditional a13 =  createConditional (v11,v28,v35,v39,v7,v12,v41,v43,v2,v3,v8,v13,v37,v29,v33,v34,v38,v44,v1,v14,v17,v22,v23,v30,v40,v19);
		Conditional a14 =  createConditional (v16,v30,v34,v4,v26,v36,v20,v23,v25,v35,v2,v3,v10,v13,v24,v39,v6,v17,v28,v38,v32,v44,v11,v19,v43,v29);
		Conditional a15 =  createConditional (v5,v9,v15,v21,v30,v6,v12,v18,v24,v25,v43,v19,v29,v42,v26,v31,v38,v4,v1,v7,v17,v39,v45,v13,v22,v27,v32);
		Conditional a16 =  createConditional (v12,v31,v41,v43,v20,v23,v29,v5,v36,v8,v30,v34,v44,v6,v7,v16,v39,v10,v13,v15,v25,v4,v21,v19,v26,v37,v42);
		Conditional a17 =  createConditional (v9,v18,v24,v41,v4,v16,v7,v45,v10,v11,v12,v13,v17,v22,v36,v23,v31,v37,v1,v43,v28,v30,v42,v2,v8,v6);
		Conditional a18 =  createConditional (v41,v1,v3,v27,v35,v42,v14,v20,v22,v39,v16,v31,v45,v12,v18,v21,v25,v37,v40,v8,v23,v4,v9,v11,v44,v5,v34);
		Conditional a19 =  createConditional (v31,v36,v43,v44,v34,v7,v8,v10,v16,v24,v27,v29,v32,v42,v1,v2,v26,v28,v39,v45,v3,v41,v19,v37,v22,v13);
		Conditional a20 =  createConditional (v12,v14,v28,v33,v6,v21,v25,v2,v3,v17,v29,v4,v8,v10,v15,v26,v31,v16,v5,v13,v23,v34,v36,v1,v44,v35,v38,v45);
		Conditional a21 =  createConditional (v9,v17,v19,v25,v33,v7,v13,v22,v34,v27,v28,v32,v39,v36,v37,v16,v1,v12,v15,v38,v44,v8,v45,v11,v40,v2);
		Conditional a22 =  createConditional (v17,v21,v32,v45,v8,v40,v14,v16,v24,v30,v1,v5,v26,v10,v20,v11,v29,v33,v42,v3,v12,v39,v41,v22,v44,v31,v38);
		Conditional a23 =  createConditional (v1,v17,v22,v41,v10,v20,v21,v24,v25,v37,v39,v11,v30,v18,v26,v33,v32,v8,v16,v45,v3,v4,v35,v36,v12,v29,v40);
		Conditional a24 =  createConditional (v2,v8,v11,v25,v38,v1,v12,v14,v24,v39,v41,v43,v22,v26,v7,v16,v18,v4,v6,v19,v33,v34,v17,v23,v3,v31,v37);
		Conditional a25 =  createConditional (v3,v10,v13,v20,v24,v12,v18,v27,v7,v25,v32,v39,v1,v9,v23,v21,v38,v45,v26,v42,v2,v15,v19,v22,v41,v11);
		Conditional a26 =  createConditional (v3,v20,v10,v14,v24,v40,v27,v35,v41,v44,v19,v30,v4,v17,v23,v15,v43,v16,v26,v13,v28,v45,v22,v12,v29,v42);
		Conditional a27 =  createConditional (v8,v29,v26,v38,v40,v41,v17,v18,v20,v24,v4,v9,v25,v28,v1,v3,v30,v31,v45,v19,v35,v43,v13,v15,v21,v37);
		Conditional a28 =  createConditional (v3,v5,v7,v35,v6,v12,v20,v32,v42,v45,v1,v4,v14,v23,v13,v30,v33,v38,v8,v10,v15,v29,v18,v11,v28,v36);
		Conditional a29 =  createConditional (v24,v38,v43,v21,v22,v34,v44,v7,v36,v37,v10,v25,v33,v3,v20,v26,v27,v2,v4,v8,v11,v40,v1,v6,v30,v39,v45);
		Conditional a30 =  createConditional (v6,v10,v25,v45,v15,v24,v28,v7,v31,v33,v36,v3,v11,v21,v43,v4,v38,v41,v2,v12,v13,v34,v17,v23,v42,v5);
		Conditional a31 =  createConditional (v2,v8,v11,v18,v23,v25,v29,v30,v36,v10,v12,v37,v9,v16,v19,v22,v14,v17,v24,v34,v35,v13,v28,v33,v41,v42,v45);
		Conditional a32 =  createConditional (v28,v36,v10,v25,v26,v32,v39,v19,v20,v34,v29,v24,v31,v37,v16,v30,v45,v12,v13,v4,v42,v2,v35,v6,v14,v15,v21,v22,v41,v43,v44);
		Conditional a33 =  createConditional (v31,v6,v22,v23,v33,v44,v45,v4,v7,v16,v20,v29,v43,v39,v5,v17,v36,v41,v8,v9,v24,v25,v18,v28,v35,v1,v19,v42);
		Conditional a34 =  createConditional (v4,v30,v31,v32,v33,v35,v42,v44,v1,v28,v34,v40,v13,v7,v8,v9,v24,v16,v22,v29,v37,v14,v18,v20,v3,v41);
		Conditional a35 =  createConditional (v6,v12,v28,v38,v11,v19,v25,v30,v35,v36,v7,v10,v13,v17,v24,v31,v33,v39,v41,v43,v9,v32,v37,v42,v23,v5,v20);
		Conditional a36 =  createConditional (v2,v13,v18,v28,v38,v1,v10,v25,v26,v33,v42,v9,v16,v41,v43,v3,v5,v19,v29,v37,v44,v24,v6,v11,v17,v20,v21,v34);
		Conditional a37 =  createConditional (v18,v19,v28,v35,v40,v41,v8,v12,v24,v15,v21,v29,v30,v1,v37,v16,v6,v11,v25,v36,v10,v20,v44,v22,v5,v42);
		Conditional a38 =  createConditional (v2,v12,v17,v35,v13,v19,v41,v9,v10,v14,v22,v28,v29,v37,v39,v44,v11,v16,v20,v32,v36,v15,v23,v42,v4,v25,v31,v43);
		Conditional a39 =  createConditional (v9,v27,v30,v36,v42,v1,v7,v12,v21,v38,v8,v19,v41,v2,v16,v10,v18,v20,v35,v44,v25,v28,v33,v39,v17,v32,v45);
		Conditional a40 =  createConditional (v13,v41,v43,v45,v1,v10,v23,v25,v30,v32,v34,v38,v5,v6,v8,v12,v28,v35,v3,v26,v31,v16,v42,v37,v21,v24);
		Conditional a41 =  createConditional (v12,v15,v16,v18,v25,v32,v44,v2,v11,v20,v31,v17,v35,v1,v36,v40,v5,v27,v28,v41,v45,v4,v39,v29,v43,v10,v42);
		Conditional a42 =  createConditional (v5,v9,v38,v40,v11,v12,v15,v18,v4,v10,v30,v6,v32,v33,v39,v13,v25,v36,v37,v42,v44,v20,v22,v23,v27,v31,v41);
		Conditional a43 =  createConditional (v3,v11,v14,v17,v42,v43,v15,v24,v28,v31,v33,v36,v1,v4,v19,v23,v2,v16,v18,v20,v32,v39,v44,v6,v22,v25,v34);
		Conditional a44 =  createConditional (v25,v41,v21,v27,v30,v38,v39,v43,v14,v23,v24,v8,v15,v16,v33,v45,v6,v9,v17,v19,v29,v34,v20,v22,v5,v11,v12,v31);
		Conditional a45 =  createConditional (v12,v14,v19,v25,v29,v30,v34,v43,v5,v32,v35,v37,v4,v22,v38,v3,v8,v18,v24,v27,v7,v10,v26,v44,v6,v16);
		Conditional a46 =  createConditional (v31,v40,v25,v35,v7,v6,v9,v20,v26,v27,v41,v17,v23,v28,v1,v19,v21,v15,v5,v8,v10,v11,v12,v29,v3,v43);
		Conditional a47 =  createConditional (v1,v5,v10,v19,v15,v17,v20,v23,v24,v25,v33,v35,v2,v3,v21,v26,v18,v27,v13,v37,v40,v14,v28,v4,v29,v41);
		Conditional a48 =  createConditional (v16,v34,v40,v1,v5,v9,v17,v18,v19,v25,v33,v43,v44,v13,v37,v45,v3,v27,v41,v28,v12,v14,v23,v32,v29,v30);
		Conditional a49 =  createConditional (v7,v10,v18,v21,v22,v28,v35,v4,v20,v41,v6,v19,v24,v36,v42,v45,v23,v27,v44,v3,v13,v29,v2,v17,v25,v40);
		Conditional a50 =  createConditional (v41,v42,v8,v13,v22,v32,v33,v1,v18,v24,v35,v43,v20,v31,v45,v25,v36,v21,v12,v26,v37,v23,v34,v10,v27,v29);
		Conditional a51 =  createConditional (v3,v13,v25,v28,v32,v43,v9,v27,v34,v1,v30,v19,v31,v35,v10,v11,v40,v15,v16,v26,v21,v37,v18,v24,v29,v7);
		Conditional a52 =  createConditional (v3,v7,v12,v14,v35,v38,v8,v21,v28,v32,v43,v22,v2,v13,v34,v42,v5,v18,v23,v30,v45,v15,v19,v17,v44,v33);
		Conditional a53 =  createConditional (v1,v4,v6,v14,v21,v31,v35,v45,v3,v17,v19,v20,v26,v39,v18,v42,v43,v5,v10,v24,v34,v44,v12,v29,v2,v11,v40);
		Conditional a54 =  createConditional (v8,v9,v19,v28,v31,v32,v43,v2,v6,v10,v20,v27,v34,v13,v36,v3,v12,v30,v18,v23,v11,v17,v22,v33,v35,v7,v16,v41);
		Conditional a55 =  createConditional (v9,v12,v14,v15,v16,v31,v6,v8,v24,v39,v43,v20,v35,v40,v7,v36,v11,v28,v42,v45,v13,v26,v34,v37,v3,v5,v19,v44);
		Conditional a56 =  createConditional (v1,v12,v37,v43,v35,v4,v9,v10,v11,v15,v25,v28,v31,v38,v41,v45,v3,v5,v14,v20,v24,v39,v40,v44,v6,v32,v34);
		Conditional a57 =  createConditional (v8,v10,v25,v40,v42,v14,v15,v20,v21,v18,v38,v44,v2,v5,v9,v19,v26,v29,v16,v17,v32,v39,v24,v23,v36,v37);
		Conditional a58 =  createConditional (v21,v29,v45,v2,v17,v22,v40,v7,v14,v34,v39,v9,v15,v25,v33,v31,v4,v6,v24,v1,v11,v27,v36,v13,v20,v23,v28);
		Conditional a59 =  createConditional (v7,v15,v22,v32,v38,v12,v27,v29,v31,v42,v24,v35,v10,v33,v34,v6,v9,v14,v16,v18,v19,v2,v4,v25,v36,v40,v45);
		Conditional a60 =  createConditional (v6,v35,v42,v44,v10,v11,v12,v28,v39,v9,v34,v38,v2,v21,v27,v8,v29,v18,v17,v40,v4,v23,v37,v19,v41,v1,v5);
		Conditional a61 =  createConditional (v6,v7,v8,v27,v20,v17,v22,v40,v43,v35,v28,v31,v41,v42,v44,v14,v37,v45,v2,v15,v24,v39,v13,v21,v23,v36);
		Conditional a62 =  createConditional (v13,v27,v29,v37,v42,v8,v9,v19,v28,v41,v45,v3,v12,v24,v26,v34,v38,v39,v2,v11,v25,v14,v15,v20,v18,v30,v32,v44);
		Conditional a63 =  createConditional (v6,v27,v37,v16,v19,v23,v30,v35,v42,v21,v34,v22,v12,v18,v4,v11,v26,v40,v44,v15,v24,v41,v1,v29,v10,v45);
		Conditional a64 =  createConditional (v7,v14,v19,v22,v27,v29,v39,v18,v34,v8,v37,v42,v11,v17,v36,v6,v15,v24,v31,v38,v25,v28,v33,v23,v30,v35);
		Conditional a65 =  createConditional (v8,v19,v42,v43,v44,v45,v3,v17,v26,v28,v31,v33,v40,v2,v4,v14,v16,v30,v10,v29,v1,v9,v20,v22,v34,v41);
		Conditional a66 =  createConditional (v4,v25,v26,v33,v1,v5,v8,v15,v27,v34,v39,v3,v42,v9,v14,v20,v23,v35,v13,v12,v24,v7,v16,v28,v22,v30,v37);
		Conditional a67 =  createConditional (v10,v14,v15,v28,v33,v4,v26,v44,v9,v5,v12,v19,v29,v40,v17,v18,v25,v31,v36,v43,v23,v34,v42,v35,v1,v30);
		Conditional a68 =  createConditional (v4,v13,v36,v5,v7,v10,v34,v42,v16,v22,v32,v9,v17,v24,v27,v6,v20,v45,v25,v8,v15,v19,v23,v26,v33,v43);
		Conditional a69 =  createConditional (v31,v36,v7,v8,v16,v19,v23,v33,v21,v38,v40,v44,v17,v20,v30,v45,v10,v32,v37,v43,v4,v5,v35,v42,v22,v1,v2,v18,v29);
		Conditional a70 =  createConditional (v40,v7,v14,v17,v21,v36,v41,v12,v13,v27,v44,v6,v22,v34,v1,v3,v16,v2,v9,v25,v35,v20,v26,v31,v37,v45);
		Conditional a71 =  createConditional (v20,v22,v43,v10,v21,v23,v38,v40,v44,v18,v41,v28,v32,v4,v8,v16,v25,v29,v36,v11,v13,v33,v7,v34,v35,v37);
		Conditional a72 =  createConditional (v2,v5,v7,v18,v30,v6,v23,v31,v37,v42,v43,v9,v17,v28,v34,v40,v10,v11,v4,v33,v44,v21,v25,v1,v3,v35,v36);
		Conditional a73 =  createConditional (v8,v24,v42,v1,v9,v12,v34,v44,v6,v18,v19,v36,v38,v40,v41,v13,v25,v29,v43,v3,v35,v10,v16,v4,v32,v14);
		Conditional a74 =  createConditional (v1,v4,v19,v21,v26,v39,v44,v6,v14,v30,v31,v32,v3,v25,v35,v29,v41,v2,v16,v22,v24,v38,v45,v37,v28,v18,v40);
		Conditional a75 =  createConditional (v1,v11,v16,v37,v41,v8,v14,v19,v31,v34,v42,v2,v12,v13,v17,v36,v5,v10,v26,v35,v4,v6,v18,v24,v25,v33);
		Conditional a76 =  createConditional (v13,v44,v3,v4,v18,v26,v45,v17,v20,v24,v38,v41,v19,v33,v40,v43,v27,v12,v28,v14,v42,v21,v34,v1,v10,v35);
		Conditional a77 =  createConditional (v7,v8,v13,v15,v1,v6,v19,v33,v40,v41,v20,v22,v28,v29,v39,v43,v31,v32,v12,v2,v16,v25,v44,v26,v42,v21);
		Conditional a78 =  createConditional (v13,v24,v37,v10,v14,v18,v22,v35,v6,v17,v23,v29,v39,v42,v2,v4,v12,v27,v28,v33,v7,v45,v3,v21,v40,v9,v43);
		Conditional a79 =  createConditional (v6,v17,v24,v11,v3,v4,v10,v34,v36,v37,v2,v7,v8,v9,v31,v1,v16,v28,v18,v39,v40,v43,v30,v26,v42,v23,v33,v41);
		Conditional a80 =  createConditional (v6,v8,v18,v27,v29,v40,v45,v3,v9,v14,v32,v38,v44,v4,v12,v10,v23,v26,v34,v16,v17,v20,v21,v33,v39,v25,v36);
	
		Conditional.setPrecision(210);
		Conditional.setMathContext(new MathContext(210,RoundingMode.DOWN));
		
		PInstance pInstance = createPIntance(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a21,a22,a23,a24,a25,a26,a27,a28,a29,a30,a31,a32,a33,a34,a35,a36,a37,a38,a39,a40,a41,a42,a43,a44,a45,a46,a47,a48,a49,a50,a51,a52,a53,a54,a55,a56,a57,a58,a59,a60,a61,a62,a63,a64,a65,a66,a67,a68,a69,a70,a71,a72,a73,a74,a75,a76,a77,a78,a79,a80);
		pInstance.setVariables(Arrays.asList(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20,v21,v22,v23,v24,v25,v26,v27,v28,v29,v30,v31,v32,v33,v34,v35,v36,v37,v38,v39,v40,v41,v42,v43,v44,v45));

       // pInstance.compute_Values();
		
		pInstance.getVariables().forEach(variable->{
			//System.out.println("Variable Name:"+variable.getName()+ "Variable value:"+variable.getValue());
		});
		
	/*
		v1.setValue(0);
		v2.setValue(1);
		v3.setValue(0);
		v4.setValue(1);
		v5.setValue(0);
		v6.setValue(1);
		v7.setValue(0);
		v8.setValue(1);
		v9.setValue(0);
		v10.setValue(1);
		v11.setValue(0);
		v12.setValue(1);
		v13.setValue(0);
		v14.setValue(1);
		v15.setValue(0);
		v16.setValue(1);
		v17.setValue(0);
		v18.setValue(1);
		v19.setValue(0);
		v20.setValue(1);
		v21.setValue(0);
		v22.setValue(1);
		v23.setValue(0);
		v24.setValue(0);
		v25.setValue(1);
		v26.setValue(0);
		v27.setValue(1);
		v28.setValue(0);
		v29.setValue(0);
		v30.setValue(1);
		v31.setValue(1);
		v32.setValue(0);
		v33.setValue(1);
		v34.setValue(0);
		v35.setValue(1);
		v36.setValue(1);
		v37.setValue(0);
		v38.setValue(1);
		v39.setValue(0);
		v40.setValue(0);
		v41.setValue(1);
		v42.setValue(0);
		v43.setValue(1);
		v44.setValue(1);
		v45.setValue(0);
        */
		/*Integer sum = pInstance.getCondtionals()
				.stream()
				.collect(Collectors.summingInt(Conditional::dosum));
				System.out.println("Sum is:"+sum);
		*/		
		for(int i=0;i<100;i++){
		pInstance.setRandomValues();
		Integer sum = pInstance.getCondtionals()
		.stream()
		.collect(Collectors.summingInt(Conditional::dosum));
		System.out.println("Sum is:"+sum);
		}
	}
	
	
	
	
}
