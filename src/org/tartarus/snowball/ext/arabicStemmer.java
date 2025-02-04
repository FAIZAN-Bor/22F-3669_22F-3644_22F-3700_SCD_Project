// This file was generated automatically by the Snowball to Java compiler
// http://snowballstem.org/

package org.tartarus.snowball.ext;

import org.tartarus.snowball.Among;


public class arabicStemmer extends org.tartarus.snowball.SnowballStemmer {

    private static final long serialVersionUID = 1L;

    private final static Among a_0[] = {
        new Among ( "!", -1, 3 ),
        new Among ( "\"", -1, 3 ),
        new Among ( "%", -1, 3 ),
        new Among ( "*", -1, 3 ),
        new Among ( ",", -1, 3 ),
        new Among ( ".", -1, 3 ),
        new Among ( "/", -1, 3 ),
        new Among ( ":", -1, 3 ),
        new Among ( ";", -1, 3 ),
        new Among ( "?", -1, 3 ),
        new Among ( "\\", -1, 3 ),
        new Among ( "\u060C", -1, 4 ),
        new Among ( "\u061B", -1, 4 ),
        new Among ( "\u061F", -1, 4 ),
        new Among ( "\u0640", -1, 2 ),
        new Among ( "\u064B", -1, 1 ),
        new Among ( "\u064C", -1, 1 ),
        new Among ( "\u064D", -1, 1 ),
        new Among ( "\u064E", -1, 1 ),
        new Among ( "\u064F", -1, 1 ),
        new Among ( "\u0650", -1, 1 ),
        new Among ( "\u0651", -1, 1 ),
        new Among ( "\u0652", -1, 1 ),
        new Among ( "\u0660", -1, 5 ),
        new Among ( "\u0661", -1, 6 ),
        new Among ( "\u0662", -1, 7 ),
        new Among ( "\u0663", -1, 8 ),
        new Among ( "\u0664", -1, 9 ),
        new Among ( "\u0665", -1, 10 ),
        new Among ( "\u0666", -1, 11 ),
        new Among ( "\u0667", -1, 12 ),
        new Among ( "\u0668", -1, 13 ),
        new Among ( "\u0669", -1, 14 ),
        new Among ( "\u066A", -1, 15 ),
        new Among ( "\u066B", -1, 15 ),
        new Among ( "\u066C", -1, 15 ),
        new Among ( "\uFE80", -1, 16 ),
        new Among ( "\uFE81", -1, 20 ),
        new Among ( "\uFE82", -1, 20 ),
        new Among ( "\uFE83", -1, 17 ),
        new Among ( "\uFE84", -1, 17 ),
        new Among ( "\uFE85", -1, 21 ),
        new Among ( "\uFE86", -1, 21 ),
        new Among ( "\uFE87", -1, 18 ),
        new Among ( "\uFE88", -1, 18 ),
        new Among ( "\uFE89", -1, 19 ),
        new Among ( "\uFE8A", -1, 19 ),
        new Among ( "\uFE8B", -1, 19 ),
        new Among ( "\uFE8C", -1, 19 ),
        new Among ( "\uFE8D", -1, 22 ),
        new Among ( "\uFE8E", -1, 22 ),
        new Among ( "\uFE8F", -1, 23 ),
        new Among ( "\uFE90", -1, 23 ),
        new Among ( "\uFE91", -1, 23 ),
        new Among ( "\uFE92", -1, 23 ),
        new Among ( "\uFE93", -1, 24 ),
        new Among ( "\uFE94", -1, 24 ),
        new Among ( "\uFE95", -1, 25 ),
        new Among ( "\uFE96", -1, 25 ),
        new Among ( "\uFE97", -1, 25 ),
        new Among ( "\uFE98", -1, 25 ),
        new Among ( "\uFE99", -1, 26 ),
        new Among ( "\uFE9A", -1, 26 ),
        new Among ( "\uFE9B", -1, 26 ),
        new Among ( "\uFE9C", -1, 26 ),
        new Among ( "\uFE9D", -1, 27 ),
        new Among ( "\uFE9E", -1, 27 ),
        new Among ( "\uFE9F", -1, 27 ),
        new Among ( "\uFEA0", -1, 27 ),
        new Among ( "\uFEA1", -1, 28 ),
        new Among ( "\uFEA2", -1, 28 ),
        new Among ( "\uFEA3", -1, 28 ),
        new Among ( "\uFEA4", -1, 28 ),
        new Among ( "\uFEA5", -1, 29 ),
        new Among ( "\uFEA6", -1, 29 ),
        new Among ( "\uFEA7", -1, 29 ),
        new Among ( "\uFEA8", -1, 29 ),
        new Among ( "\uFEA9", -1, 30 ),
        new Among ( "\uFEAA", -1, 30 ),
        new Among ( "\uFEAB", -1, 31 ),
        new Among ( "\uFEAC", -1, 31 ),
        new Among ( "\uFEAD", -1, 32 ),
        new Among ( "\uFEAE", -1, 32 ),
        new Among ( "\uFEAF", -1, 33 ),
        new Among ( "\uFEB0", -1, 33 ),
        new Among ( "\uFEB1", -1, 34 ),
        new Among ( "\uFEB2", -1, 34 ),
        new Among ( "\uFEB3", -1, 34 ),
        new Among ( "\uFEB4", -1, 34 ),
        new Among ( "\uFEB5", -1, 35 ),
        new Among ( "\uFEB6", -1, 35 ),
        new Among ( "\uFEB7", -1, 35 ),
        new Among ( "\uFEB8", -1, 35 ),
        new Among ( "\uFEB9", -1, 36 ),
        new Among ( "\uFEBA", -1, 36 ),
        new Among ( "\uFEBB", -1, 36 ),
        new Among ( "\uFEBC", -1, 36 ),
        new Among ( "\uFEBD", -1, 37 ),
        new Among ( "\uFEBE", -1, 37 ),
        new Among ( "\uFEBF", -1, 37 ),
        new Among ( "\uFEC0", -1, 37 ),
        new Among ( "\uFEC1", -1, 38 ),
        new Among ( "\uFEC2", -1, 38 ),
        new Among ( "\uFEC3", -1, 38 ),
        new Among ( "\uFEC4", -1, 38 ),
        new Among ( "\uFEC5", -1, 39 ),
        new Among ( "\uFEC6", -1, 39 ),
        new Among ( "\uFEC7", -1, 39 ),
        new Among ( "\uFEC8", -1, 39 ),
        new Among ( "\uFEC9", -1, 40 ),
        new Among ( "\uFECA", -1, 40 ),
        new Among ( "\uFECB", -1, 40 ),
        new Among ( "\uFECC", -1, 40 ),
        new Among ( "\uFECD", -1, 41 ),
        new Among ( "\uFECE", -1, 41 ),
        new Among ( "\uFECF", -1, 41 ),
        new Among ( "\uFED0", -1, 41 ),
        new Among ( "\uFED1", -1, 42 ),
        new Among ( "\uFED2", -1, 42 ),
        new Among ( "\uFED3", -1, 42 ),
        new Among ( "\uFED4", -1, 42 ),
        new Among ( "\uFED5", -1, 43 ),
        new Among ( "\uFED6", -1, 43 ),
        new Among ( "\uFED7", -1, 43 ),
        new Among ( "\uFED8", -1, 43 ),
        new Among ( "\uFED9", -1, 44 ),
        new Among ( "\uFEDA", -1, 44 ),
        new Among ( "\uFEDB", -1, 44 ),
        new Among ( "\uFEDC", -1, 44 ),
        new Among ( "\uFEDD", -1, 45 ),
        new Among ( "\uFEDE", -1, 45 ),
        new Among ( "\uFEDF", -1, 45 ),
        new Among ( "\uFEE0", -1, 45 ),
        new Among ( "\uFEE1", -1, 46 ),
        new Among ( "\uFEE2", -1, 46 ),
        new Among ( "\uFEE3", -1, 46 ),
        new Among ( "\uFEE4", -1, 46 ),
        new Among ( "\uFEE5", -1, 47 ),
        new Among ( "\uFEE6", -1, 47 ),
        new Among ( "\uFEE7", -1, 47 ),
        new Among ( "\uFEE8", -1, 47 ),
        new Among ( "\uFEE9", -1, 48 ),
        new Among ( "\uFEEA", -1, 48 ),
        new Among ( "\uFEEB", -1, 48 ),
        new Among ( "\uFEEC", -1, 48 ),
        new Among ( "\uFEED", -1, 49 ),
        new Among ( "\uFEEE", -1, 49 ),
        new Among ( "\uFEEF", -1, 50 ),
        new Among ( "\uFEF0", -1, 50 ),
        new Among ( "\uFEF1", -1, 51 ),
        new Among ( "\uFEF2", -1, 51 ),
        new Among ( "\uFEF3", -1, 51 ),
        new Among ( "\uFEF4", -1, 51 ),
        new Among ( "\uFEF5", -1, 55 ),
        new Among ( "\uFEF6", -1, 55 ),
        new Among ( "\uFEF7", -1, 53 ),
        new Among ( "\uFEF8", -1, 53 ),
        new Among ( "\uFEF9", -1, 54 ),
        new Among ( "\uFEFA", -1, 54 ),
        new Among ( "\uFEFB", -1, 52 ),
        new Among ( "\uFEFC", -1, 52 )
    };

    private final static Among a_1[] = {
        new Among ( "\u0622", -1, 1 ),
        new Among ( "\u0623", -1, 1 ),
        new Among ( "\u0624", -1, 2 ),
        new Among ( "\u0625", -1, 1 ),
        new Among ( "\u0626", -1, 3 )
    };

    private final static Among a_2[] = {
        new Among ( "\u0622", -1, 1 ),
        new Among ( "\u0623", -1, 1 ),
        new Among ( "\u0624", -1, 2 ),
        new Among ( "\u0625", -1, 1 ),
        new Among ( "\u0626", -1, 3 )
    };

    private final static Among a_3[] = {
        new Among ( "\u0627\u0644", -1, 2 ),
        new Among ( "\u0628\u0627\u0644", -1, 1 ),
        new Among ( "\u0643\u0627\u0644", -1, 1 ),
        new Among ( "\u0644\u0644", -1, 2 )
    };

    private final static Among a_4[] = {
        new Among ( "\u0629", -1, 1 )
    };

    private final static Among a_5[] = {
        new Among ( "\u0623\u0622", -1, 2 ),
        new Among ( "\u0623\u0623", -1, 1 ),
        new Among ( "\u0623\u0624", -1, 3 ),
        new Among ( "\u0623\u0625", -1, 5 ),
        new Among ( "\u0623\u0627", -1, 4 )
    };

    private final static Among a_6[] = {
        new Among ( "\u0641\u0627\u0644", -1, 1 ),
        new Among ( "\u0648\u0627\u0644", -1, 2 )
    };

    private final static Among a_7[] = {
        new Among ( "\u0641", -1, 1 ),
        new Among ( "\u0648", -1, 2 )
    };

    private final static Among a_8[] = {
        new Among ( "\u0627\u0644", -1, 2 ),
        new Among ( "\u0628\u0627\u0644", -1, 1 ),
        new Among ( "\u0643\u0627\u0644", -1, 1 ),
        new Among ( "\u0644\u0644", -1, 2 )
    };

    private final static Among a_9[] = {
        new Among ( "\u0628", -1, 1 ),
        new Among ( "\u0628\u0628", 0, 4 ),
        new Among ( "\u0643", -1, 2 ),
        new Among ( "\u0643\u0643", 2, 5 ),
        new Among ( "\u0644", -1, 3 )
    };

    private final static Among a_10[] = {
        new Among ( "\u0633\u0623", -1, 4 ),
        new Among ( "\u0633\u062A", -1, 2 ),
        new Among ( "\u0633\u0646", -1, 3 ),
        new Among ( "\u0633\u064A", -1, 1 )
    };

    private final static Among a_11[] = {
        new Among ( "\u062A\u0633\u062A", -1, 1 ),
        new Among ( "\u0646\u0633\u062A", -1, 1 ),
        new Among ( "\u064A\u0633\u062A", -1, 1 )
    };

    private final static Among a_12[] = {
        new Among ( "\u0643\u0645\u0627", -1, 3 ),
        new Among ( "\u0647\u0645\u0627", -1, 3 ),
        new Among ( "\u0646\u0627", -1, 2 ),
        new Among ( "\u0647\u0627", -1, 2 ),
        new Among ( "\u0643", -1, 1 ),
        new Among ( "\u0643\u0645", -1, 2 ),
        new Among ( "\u0647\u0645", -1, 2 ),
        new Among ( "\u0647\u0646", -1, 2 ),
        new Among ( "\u0647", -1, 1 ),
        new Among ( "\u064A", -1, 1 )
    };

    private final static Among a_13[] = {
        new Among ( "\u0646", -1, 1 )
    };

    private final static Among a_14[] = {
        new Among ( "\u0627", -1, 1 ),
        new Among ( "\u0648", -1, 1 ),
        new Among ( "\u064A", -1, 1 )
    };

    private final static Among a_15[] = {
        new Among ( "\u0627\u062A", -1, 1 )
    };

    private final static Among a_16[] = {
        new Among ( "\u062A", -1, 1 )
    };

    private final static Among a_17[] = {
        new Among ( "\u0629", -1, 1 )
    };

    private final static Among a_18[] = {
        new Among ( "\u064A", -1, 1 )
    };

    private final static Among a_19[] = {
        new Among ( "\u0643\u0645\u0627", -1, 3 ),
        new Among ( "\u0647\u0645\u0627", -1, 3 ),
        new Among ( "\u0646\u0627", -1, 2 ),
        new Among ( "\u0647\u0627", -1, 2 ),
        new Among ( "\u0643", -1, 1 ),
        new Among ( "\u0643\u0645", -1, 2 ),
        new Among ( "\u0647\u0645", -1, 2 ),
        new Among ( "\u0643\u0646", -1, 2 ),
        new Among ( "\u0647\u0646", -1, 2 ),
        new Among ( "\u0647", -1, 1 ),
        new Among ( "\u0643\u0645\u0648", -1, 3 ),
        new Among ( "\u0646\u064A", -1, 2 )
    };

    private final static Among a_20[] = {
        new Among ( "\u0627", -1, 2 ),
        new Among ( "\u062A\u0627", 0, 3 ),
        new Among ( "\u062A\u0645\u0627", 0, 5 ),
        new Among ( "\u0646\u0627", 0, 3 ),
        new Among ( "\u062A", -1, 1 ),
        new Among ( "\u0646", -1, 2 ),
        new Among ( "\u0627\u0646", 5, 4 ),
        new Among ( "\u062A\u0646", 5, 3 ),
        new Among ( "\u0648\u0646", 5, 4 ),
        new Among ( "\u064A\u0646", 5, 4 ),
        new Among ( "\u064A", -1, 2 )
    };

    private final static Among a_21[] = {
        new Among ( "\u0648\u0627", -1, 1 ),
        new Among ( "\u062A\u0645", -1, 1 )
    };

    private final static Among a_22[] = {
        new Among ( "\u0648", -1, 1 ),
        new Among ( "\u062A\u0645\u0648", 0, 2 )
    };

    private final static Among a_23[] = {
        new Among ( "\u0649", -1, 1 )
    };

    private boolean B_is_defined;
    private boolean B_is_verb;
    private boolean B_is_noun;
    private int I_word_len;


    private boolean r_Normalize_pre() {
        int among_var;
        int v_1;
        int v_2;
        // (, line 260
        // loop, line 261
        for (v_1 = (current.length()); v_1 > 0; v_1--)
        {
            // (, line 261
            // or, line 330
            lab0: do {
                v_2 = cursor;
                lab1: do {
                    // (, line 262
                    // [, line 263
                    bra = cursor;
                    // substring, line 263
                    among_var = find_among(a_0);
                    if (among_var == 0)
                    {
                        break lab1;
                    }
                    // ], line 263
                    ket = cursor;
                    switch (among_var) {
                        case 0:
                            break lab1;
                        case 1:
                            // (, line 264
                            // delete, line 264
                            slice_del();
                            break;
                        case 2:
                            // (, line 265
                            // delete, line 265
                            slice_del();
                            break;
                        case 3:
                            // (, line 268
                            // delete, line 268
                            slice_del();
                            break;
                        case 4:
                            // (, line 269
                            // delete, line 269
                            slice_del();
                            break;
                        case 5:
                            // (, line 272
                            // <-, line 272
                            slice_from("0");
                            break;
                        case 6:
                            // (, line 273
                            // <-, line 273
                            slice_from("1");
                            break;
                        case 7:
                            // (, line 274
                            // <-, line 274
                            slice_from("2");
                            break;
                        case 8:
                            // (, line 275
                            // <-, line 275
                            slice_from("3");
                            break;
                        case 9:
                            // (, line 276
                            // <-, line 276
                            slice_from("4");
                            break;
                        case 10:
                            // (, line 277
                            // <-, line 277
                            slice_from("5");
                            break;
                        case 11:
                            // (, line 278
                            // <-, line 278
                            slice_from("6");
                            break;
                        case 12:
                            // (, line 279
                            // <-, line 279
                            slice_from("7");
                            break;
                        case 13:
                            // (, line 280
                            // <-, line 280
                            slice_from("8");
                            break;
                        case 14:
                            // (, line 281
                            // <-, line 281
                            slice_from("9");
                            break;
                        case 15:
                            // (, line 282
                            // delete, line 282
                            slice_del();
                            break;
                        case 16:
                            // (, line 285
                            // <-, line 285
                            slice_from("\u0621");
                            break;
                        case 17:
                            // (, line 286
                            // <-, line 286
                            slice_from("\u0623");
                            break;
                        case 18:
                            // (, line 287
                            // <-, line 287
                            slice_from("\u0625");
                            break;
                        case 19:
                            // (, line 288
                            // <-, line 288
                            slice_from("\u0626");
                            break;
                        case 20:
                            // (, line 289
                            // <-, line 289
                            slice_from("\u0622");
                            break;
                        case 21:
                            // (, line 290
                            // <-, line 290
                            slice_from("\u0624");
                            break;
                        case 22:
                            // (, line 291
                            // <-, line 291
                            slice_from("\u0627");
                            break;
                        case 23:
                            // (, line 292
                            // <-, line 292
                            slice_from("\u0628");
                            break;
                        case 24:
                            // (, line 293
                            // <-, line 293
                            slice_from("\u0629");
                            break;
                        case 25:
                            // (, line 294
                            // <-, line 294
                            slice_from("\u062A");
                            break;
                        case 26:
                            // (, line 295
                            // <-, line 295
                            slice_from("\u062B");
                            break;
                        case 27:
                            // (, line 296
                            // <-, line 296
                            slice_from("\u062C");
                            break;
                        case 28:
                            // (, line 297
                            // <-, line 297
                            slice_from("\u062D");
                            break;
                        case 29:
                            // (, line 298
                            // <-, line 298
                            slice_from("\u062E");
                            break;
                        case 30:
                            // (, line 299
                            // <-, line 299
                            slice_from("\u062F");
                            break;
                        case 31:
                            // (, line 300
                            // <-, line 300
                            slice_from("\u0630");
                            break;
                        case 32:
                            // (, line 301
                            // <-, line 301
                            slice_from("\u0631");
                            break;
                        case 33:
                            // (, line 302
                            // <-, line 302
                            slice_from("\u0632");
                            break;
                        case 34:
                            // (, line 303
                            // <-, line 303
                            slice_from("\u0633");
                            break;
                        case 35:
                            // (, line 304
                            // <-, line 304
                            slice_from("\u0634");
                            break;
                        case 36:
                            // (, line 305
                            // <-, line 305
                            slice_from("\u0635");
                            break;
                        case 37:
                            // (, line 306
                            // <-, line 306
                            slice_from("\u0636");
                            break;
                        case 38:
                            // (, line 307
                            // <-, line 307
                            slice_from("\u0637");
                            break;
                        case 39:
                            // (, line 308
                            // <-, line 308
                            slice_from("\u0638");
                            break;
                        case 40:
                            // (, line 309
                            // <-, line 309
                            slice_from("\u0639");
                            break;
                        case 41:
                            // (, line 310
                            // <-, line 310
                            slice_from("\u063A");
                            break;
                        case 42:
                            // (, line 311
                            // <-, line 311
                            slice_from("\u0641");
                            break;
                        case 43:
                            // (, line 312
                            // <-, line 312
                            slice_from("\u0642");
                            break;
                        case 44:
                            // (, line 313
                            // <-, line 313
                            slice_from("\u0643");
                            break;
                        case 45:
                            // (, line 314
                            // <-, line 314
                            slice_from("\u0644");
                            break;
                        case 46:
                            // (, line 315
                            // <-, line 315
                            slice_from("\u0645");
                            break;
                        case 47:
                            // (, line 316
                            // <-, line 316
                            slice_from("\u0646");
                            break;
                        case 48:
                            // (, line 317
                            // <-, line 317
                            slice_from("\u0647");
                            break;
                        case 49:
                            // (, line 318
                            // <-, line 318
                            slice_from("\u0648");
                            break;
                        case 50:
                            // (, line 319
                            // <-, line 319
                            slice_from("\u0649");
                            break;
                        case 51:
                            // (, line 320
                            // <-, line 320
                            slice_from("\u064A");
                            break;
                        case 52:
                            // (, line 323
                            // <-, line 323
                            slice_from("\u0644\u0627");
                            break;
                        case 53:
                            // (, line 324
                            // <-, line 324
                            slice_from("\u0644\u0623");
                            break;
                        case 54:
                            // (, line 325
                            // <-, line 325
                            slice_from("\u0644\u0625");
                            break;
                        case 55:
                            // (, line 326
                            // <-, line 326
                            slice_from("\u0644\u0622");
                            break;
                    }
                    break lab0;
                } while (false);
                cursor = v_2;
                // next, line 331
                if (cursor >= limit)
                {
                    return false;
                }
                cursor++;
            } while (false);
        }
        return true;
    }

    private boolean r_Normalize_post() {
        int among_var;
        int v_1;
        int v_2;
        int v_3;
        int v_4;
        // (, line 335
        // do, line 337
        v_1 = cursor;
        lab0: do {
            // (, line 337
            // backwards, line 339
            limit_backward = cursor; cursor = limit;
            // (, line 339
            // [, line 340
            ket = cursor;
            // substring, line 340
            among_var = find_among_b(a_1);
            if (among_var == 0)
            {
                break lab0;
            }
            // ], line 340
            bra = cursor;
            switch (among_var) {
                case 0:
                    break lab0;
                case 1:
                    // (, line 341
                    // <-, line 341
                    slice_from("\u0621");
                    break;
                case 2:
                    // (, line 342
                    // <-, line 342
                    slice_from("\u0621");
                    break;
                case 3:
                    // (, line 343
                    // <-, line 343
                    slice_from("\u0621");
                    break;
            }
            cursor = limit_backward;        } while (false);
        cursor = v_1;
        // do, line 348
        v_2 = cursor;
        lab1: do {
            // loop, line 348
            for (v_3 = I_word_len; v_3 > 0; v_3--)
            {
                // (, line 348
                // or, line 357
                lab2: do {
                    v_4 = cursor;
                    lab3: do {
                        // (, line 349
                        // [, line 351
                        bra = cursor;
                        // substring, line 351
                        among_var = find_among(a_2);
                        if (among_var == 0)
                        {
                            break lab3;
                        }
                        // ], line 351
                        ket = cursor;
                        switch (among_var) {
                            case 0:
                                break lab3;
                            case 1:
                                // (, line 352
                                // <-, line 352
                                slice_from("\u0627");
                                break;
                            case 2:
                                // (, line 353
                                // <-, line 353
                                slice_from("\u0648");
                                break;
                            case 3:
                                // (, line 354
                                // <-, line 354
                                slice_from("\u064A");
                                break;
                        }
                        break lab2;
                    } while (false);
                    cursor = v_4;
                    // next, line 358
                    if (cursor >= limit)
                    {
                        break lab1;
                    }
                    cursor++;
                } while (false);
            }
        } while (false);
        cursor = v_2;
        return true;
    }

    private boolean r_Checks1() {
        int among_var;
        // (, line 363
        I_word_len = (current.length());
        // [, line 365
        bra = cursor;
        // substring, line 365
        among_var = find_among(a_3);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 365
        ket = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 366
                if (!(I_word_len > 4))
                {
                    return false;
                }
                // set is_noun, line 366
                B_is_noun = true;
                // unset is_verb, line 366
                B_is_verb = false;
                // set is_defined, line 366
                B_is_defined = true;
                break;
            case 2:
                // (, line 367
                if (!(I_word_len > 3))
                {
                    return false;
                }
                // set is_noun, line 367
                B_is_noun = true;
                // unset is_verb, line 367
                B_is_verb = false;
                // set is_defined, line 367
                B_is_defined = true;
                break;
        }
        return true;
    }

    private boolean r_Checks2() {
        int among_var;
        // (, line 373
        I_word_len = (current.length());
        // [, line 375
        ket = cursor;
        // substring, line 375
        among_var = find_among_b(a_4);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 375
        bra = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 376
                if (!(I_word_len > 2))
                {
                    return false;
                }
                // set is_noun, line 376
                B_is_noun = true;
                // unset is_verb, line 376
                B_is_verb = false;
                break;
        }
        return true;
    }

    private boolean r_Prefix_Step1() {
        int among_var;
        // (, line 382
        I_word_len = (current.length());
        // [, line 384
        bra = cursor;
        // substring, line 384
        among_var = find_among(a_5);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 384
        ket = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 385
                if (!(I_word_len > 3))
                {
                    return false;
                }
                // <-, line 385
                slice_from("\u0623");
                break;
            case 2:
                // (, line 386
                if (!(I_word_len > 3))
                {
                    return false;
                }
                // <-, line 386
                slice_from("\u0622");
                break;
            case 3:
                // (, line 387
                if (!(I_word_len > 3))
                {
                    return false;
                }
                // <-, line 387
                slice_from("\u0623");
                break;
            case 4:
                // (, line 388
                if (!(I_word_len > 3))
                {
                    return false;
                }
                // <-, line 388
                slice_from("\u0627");
                break;
            case 5:
                // (, line 389
                if (!(I_word_len > 3))
                {
                    return false;
                }
                // <-, line 389
                slice_from("\u0625");
                break;
        }
        return true;
    }

    private boolean r_Prefix_Step2a() {
        int among_var;
        // (, line 394
        I_word_len = (current.length());
        // [, line 396
        bra = cursor;
        // substring, line 396
        among_var = find_among(a_6);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 396
        ket = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 397
                if (!(I_word_len > 5))
                {
                    return false;
                }
                // delete, line 397
                slice_del();
                break;
            case 2:
                // (, line 398
                if (!(I_word_len > 5))
                {
                    return false;
                }
                // delete, line 398
                slice_del();
                break;
        }
        return true;
    }

    private boolean r_Prefix_Step2b() {
        int among_var;
        int v_1;
        int v_2;
        // (, line 402
        I_word_len = (current.length());
        // not, line 404
        {
            v_1 = cursor;
            lab0: do {
                // literal, line 404
                if (!(eq_s("\u0641\u0627")))
                {
                    break lab0;
                }
                return false;
            } while (false);
            cursor = v_1;
        }
        // not, line 405
        {
            v_2 = cursor;
            lab1: do {
                // literal, line 405
                if (!(eq_s("\u0648\u0627")))
                {
                    break lab1;
                }
                return false;
            } while (false);
            cursor = v_2;
        }
        // [, line 406
        bra = cursor;
        // substring, line 406
        among_var = find_among(a_7);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 406
        ket = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 407
                if (!(I_word_len > 3))
                {
                    return false;
                }
                // delete, line 407
                slice_del();
                break;
            case 2:
                // (, line 408
                if (!(I_word_len > 3))
                {
                    return false;
                }
                // delete, line 408
                slice_del();
                break;
        }
        return true;
    }

    private boolean r_Prefix_Step3a_Noun() {
        int among_var;
        // (, line 412
        I_word_len = (current.length());
        // [, line 414
        bra = cursor;
        // substring, line 414
        among_var = find_among(a_8);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 414
        ket = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 415
                if (!(I_word_len > 5))
                {
                    return false;
                }
                // delete, line 415
                slice_del();
                break;
            case 2:
                // (, line 416
                if (!(I_word_len > 4))
                {
                    return false;
                }
                // delete, line 416
                slice_del();
                break;
        }
        return true;
    }

    private boolean r_Prefix_Step3b_Noun() {
        int among_var;
        int v_1;
        // (, line 420
        I_word_len = (current.length());
        // not, line 422
        {
            v_1 = cursor;
            lab0: do {
                // literal, line 422
                if (!(eq_s("\u0628\u0627")))
                {
                    break lab0;
                }
                return false;
            } while (false);
            cursor = v_1;
        }
        // [, line 423
        bra = cursor;
        // substring, line 423
        among_var = find_among(a_9);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 423
        ket = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 424
                if (!(I_word_len > 3))
                {
                    return false;
                }
                // delete, line 424
                slice_del();
                break;
            case 2:
                // (, line 425
                if (!(I_word_len > 4))
                {
                    return false;
                }
                // delete, line 425
                slice_del();
                break;
            case 3:
                // (, line 426
                if (!(I_word_len > 4))
                {
                    return false;
                }
                // delete, line 426
                slice_del();
                break;
            case 4:
                // (, line 427
                if (!(I_word_len > 3))
                {
                    return false;
                }
                // <-, line 427
                slice_from("\u0628");
                break;
            case 5:
                // (, line 428
                if (!(I_word_len > 3))
                {
                    return false;
                }
                // <-, line 428
                slice_from("\u0643");
                break;
        }
        return true;
    }

    private boolean r_Prefix_Step3_Verb() {
        int among_var;
        // (, line 433
        I_word_len = (current.length());
        // [, line 435
        bra = cursor;
        // substring, line 435
        among_var = find_among(a_10);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 435
        ket = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 437
                if (!(I_word_len > 4))
                {
                    return false;
                }
                // <-, line 437
                slice_from("\u064A");
                break;
            case 2:
                // (, line 438
                if (!(I_word_len > 4))
                {
                    return false;
                }
                // <-, line 438
                slice_from("\u062A");
                break;
            case 3:
                // (, line 439
                if (!(I_word_len > 4))
                {
                    return false;
                }
                // <-, line 439
                slice_from("\u0646");
                break;
            case 4:
                // (, line 440
                if (!(I_word_len > 4))
                {
                    return false;
                }
                // <-, line 440
                slice_from("\u0623");
                break;
        }
        return true;
    }

    private boolean r_Prefix_Step4_Verb() {
        int among_var;
        // (, line 444
        I_word_len = (current.length());
        // [, line 446
        bra = cursor;
        // substring, line 446
        among_var = find_among(a_11);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 446
        ket = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 447
                if (!(I_word_len > 4))
                {
                    return false;
                }
                // set is_verb, line 447
                B_is_verb = true;
                // unset is_noun, line 447
                B_is_noun = false;
                // <-, line 447
                slice_from("\u0627\u0633\u062A");
                break;
        }
        return true;
    }

    private boolean r_Suffix_Noun_Step1a() {
        int among_var;
        // (, line 454
        I_word_len = (current.length());
        // [, line 456
        ket = cursor;
        // substring, line 456
        among_var = find_among_b(a_12);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 456
        bra = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 457
                if (!(I_word_len >= 4))
                {
                    return false;
                }
                // delete, line 457
                slice_del();
                break;
            case 2:
                // (, line 458
                if (!(I_word_len >= 5))
                {
                    return false;
                }
                // delete, line 458
                slice_del();
                break;
            case 3:
                // (, line 459
                if (!(I_word_len >= 6))
                {
                    return false;
                }
                // delete, line 459
                slice_del();
                break;
        }
        return true;
    }

    private boolean r_Suffix_Noun_Step1b() {
        int among_var;
        // (, line 462
        I_word_len = (current.length());
        // [, line 464
        ket = cursor;
        // substring, line 464
        among_var = find_among_b(a_13);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 464
        bra = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 465
                if (!(I_word_len > 5))
                {
                    return false;
                }
                // delete, line 465
                slice_del();
                break;
        }
        return true;
    }

    private boolean r_Suffix_Noun_Step2a() {
        int among_var;
        // (, line 469
        I_word_len = (current.length());
        // [, line 471
        ket = cursor;
        // substring, line 471
        among_var = find_among_b(a_14);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 471
        bra = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 472
                if (!(I_word_len > 4))
                {
                    return false;
                }
                // delete, line 472
                slice_del();
                break;
        }
        return true;
    }

    private boolean r_Suffix_Noun_Step2b() {
        int among_var;
        // (, line 476
        I_word_len = (current.length());
        // [, line 478
        ket = cursor;
        // substring, line 478
        among_var = find_among_b(a_15);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 478
        bra = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 479
                if (!(I_word_len >= 5))
                {
                    return false;
                }
                // delete, line 479
                slice_del();
                break;
        }
        return true;
    }

    private boolean r_Suffix_Noun_Step2c1() {
        int among_var;
        // (, line 483
        I_word_len = (current.length());
        // [, line 485
        ket = cursor;
        // substring, line 485
        among_var = find_among_b(a_16);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 485
        bra = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 486
                if (!(I_word_len >= 4))
                {
                    return false;
                }
                // delete, line 486
                slice_del();
                break;
        }
        return true;
    }

    private boolean r_Suffix_Noun_Step2c2() {
        int among_var;
        // (, line 489
        I_word_len = (current.length());
        // [, line 491
        ket = cursor;
        // substring, line 491
        among_var = find_among_b(a_17);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 491
        bra = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 492
                if (!(I_word_len >= 3))
                {
                    return false;
                }
                // delete, line 492
                slice_del();
                break;
        }
        return true;
    }

    private boolean r_Suffix_Noun_Step3() {
        int among_var;
        // (, line 495
        I_word_len = (current.length());
        // [, line 497
        ket = cursor;
        // substring, line 497
        among_var = find_among_b(a_18);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 497
        bra = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 498
                if (!(I_word_len >= 3))
                {
                    return false;
                }
                // delete, line 498
                slice_del();
                break;
        }
        return true;
    }

    private boolean r_Suffix_Verb_Step1() {
        int among_var;
        // (, line 502
        I_word_len = (current.length());
        // [, line 504
        ket = cursor;
        // substring, line 504
        among_var = find_among_b(a_19);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 504
        bra = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 505
                if (!(I_word_len >= 4))
                {
                    return false;
                }
                // delete, line 505
                slice_del();
                break;
            case 2:
                // (, line 506
                if (!(I_word_len >= 5))
                {
                    return false;
                }
                // delete, line 506
                slice_del();
                break;
            case 3:
                // (, line 507
                if (!(I_word_len >= 6))
                {
                    return false;
                }
                // delete, line 507
                slice_del();
                break;
        }
        return true;
    }

    private boolean r_Suffix_Verb_Step2a() {
        int among_var;
        // (, line 510
        I_word_len = (current.length());
        // [, line 512
        ket = cursor;
        // substring, line 512
        among_var = find_among_b(a_20);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 512
        bra = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 513
                if (!(I_word_len >= 4))
                {
                    return false;
                }
                // delete, line 513
                slice_del();
                break;
            case 2:
                // (, line 514
                if (!(I_word_len >= 4))
                {
                    return false;
                }
                // delete, line 514
                slice_del();
                break;
            case 3:
                // (, line 515
                if (!(I_word_len >= 5))
                {
                    return false;
                }
                // delete, line 515
                slice_del();
                break;
            case 4:
                // (, line 516
                if (!(I_word_len > 5))
                {
                    return false;
                }
                // delete, line 516
                slice_del();
                break;
            case 5:
                // (, line 517
                if (!(I_word_len >= 6))
                {
                    return false;
                }
                // delete, line 517
                slice_del();
                break;
        }
        return true;
    }

    private boolean r_Suffix_Verb_Step2b() {
        int among_var;
        // (, line 521
        I_word_len = (current.length());
        // [, line 523
        ket = cursor;
        // substring, line 523
        among_var = find_among_b(a_21);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 523
        bra = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 524
                if (!(I_word_len >= 5))
                {
                    return false;
                }
                // delete, line 524
                slice_del();
                break;
        }
        return true;
    }

    private boolean r_Suffix_Verb_Step2c() {
        int among_var;
        // (, line 529
        I_word_len = (current.length());
        // [, line 531
        ket = cursor;
        // substring, line 531
        among_var = find_among_b(a_22);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 531
        bra = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 532
                if (!(I_word_len >= 4))
                {
                    return false;
                }
                // delete, line 532
                slice_del();
                break;
            case 2:
                // (, line 533
                if (!(I_word_len >= 6))
                {
                    return false;
                }
                // delete, line 533
                slice_del();
                break;
        }
        return true;
    }

    private boolean r_Suffix_All_alef_maqsura() {
        int among_var;
        // (, line 537
        I_word_len = (current.length());
        // [, line 539
        ket = cursor;
        // substring, line 539
        among_var = find_among_b(a_23);
        if (among_var == 0)
        {
            return false;
        }
        // ], line 539
        bra = cursor;
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 540
                // <-, line 540
                slice_from("\u064A");
                break;
        }
        return true;
    }

    public boolean stem() {
        int v_1;
        int v_2;
        int v_3;
        int v_4;
        int v_5;
        int v_6;
        int v_8;
        int v_9;
        int v_10;
        int v_11;
        int v_13;
        int v_14;
        int v_16;
        int v_17;
        int v_18;
        int v_19;
        int v_20;
        int v_21;
        int v_22;
        // (, line 547
        // set is_noun, line 549
        B_is_noun = true;
        // set is_verb, line 550
        B_is_verb = true;
        // unset is_defined, line 551
        B_is_defined = false;
        // do, line 554
        v_1 = cursor;
        lab0: do {
            // call Checks1, line 554
            if (!r_Checks1())
            {
                break lab0;
            }
        } while (false);
        cursor = v_1;
        // backwards, line 555
        limit_backward = cursor; cursor = limit;
        // (, line 555
        // do, line 555
        v_2 = limit - cursor;
        lab1: do {
            // call Checks2, line 555
            if (!r_Checks2())
            {
                break lab1;
            }
        } while (false);
        cursor = limit - v_2;
        cursor = limit_backward;        // do, line 558
        v_3 = cursor;
        lab2: do {
            // call Normalize_pre, line 558
            if (!r_Normalize_pre())
            {
                break lab2;
            }
        } while (false);
        cursor = v_3;
        // backwards, line 561
        limit_backward = cursor; cursor = limit;
        // (, line 561
        // do, line 563
        v_4 = limit - cursor;
        lab3: do {
            // (, line 563
            // or, line 577
            lab4: do {
                v_5 = limit - cursor;
                lab5: do {
                    // (, line 565
                    // Boolean test is_verb, line 566
                    if (!(B_is_verb))
                    {
                        break lab5;
                    }
                    // (, line 567
                    // or, line 572
                    lab6: do {
                        v_6 = limit - cursor;
                        lab7: do {
                            // (, line 568
                            // (, line 569
                            // atleast, line 569
                            {
                                int v_7 = 1;
                                // atleast, line 569
                                replab8: while(true)
                                {
                                    v_8 = limit - cursor;
                                    lab9: do {
                                        // call Suffix_Verb_Step1, line 569
                                        if (!r_Suffix_Verb_Step1())
                                        {
                                            break lab9;
                                        }
                                        v_7--;
                                        continue replab8;
                                    } while (false);
                                    cursor = limit - v_8;
                                    break replab8;
                                }
                                if (v_7 > 0)
                                {
                                    break lab7;
                                }
                            }
                            // (, line 570
                            // or, line 570
                            lab10: do {
                                v_9 = limit - cursor;
                                lab11: do {
                                    // call Suffix_Verb_Step2a, line 570
                                    if (!r_Suffix_Verb_Step2a())
                                    {
                                        break lab11;
                                    }
                                    break lab10;
                                } while (false);
                                cursor = limit - v_9;
                                lab12: do {
                                    // call Suffix_Verb_Step2c, line 570
                                    if (!r_Suffix_Verb_Step2c())
                                    {
                                        break lab12;
                                    }
                                    break lab10;
                                } while (false);
                                cursor = limit - v_9;
                                // next, line 570
                                if (cursor <= limit_backward)
                                {
                                    break lab7;
                                }
                                cursor--;
                            } while (false);
                            break lab6;
                        } while (false);
                        cursor = limit - v_6;
                        lab13: do {
                            // call Suffix_Verb_Step2b, line 572
                            if (!r_Suffix_Verb_Step2b())
                            {
                                break lab13;
                            }
                            break lab6;
                        } while (false);
                        cursor = limit - v_6;
                        // call Suffix_Verb_Step2a, line 573
                        if (!r_Suffix_Verb_Step2a())
                        {
                            break lab5;
                        }
                    } while (false);
                    break lab4;
                } while (false);
                cursor = limit - v_5;
                lab14: do {
                    // (, line 577
                    // Boolean test is_noun, line 578
                    if (!(B_is_noun))
                    {
                        break lab14;
                    }
                    // (, line 579
                    // try, line 581
                    v_10 = limit - cursor;
                    lab15: do {
                        // (, line 581
                        // or, line 583
                        lab16: do {
                            v_11 = limit - cursor;
                            lab17: do {
                                // call Suffix_Noun_Step2c2, line 582
                                if (!r_Suffix_Noun_Step2c2())
                                {
                                    break lab17;
                                }
                                break lab16;
                            } while (false);
                            cursor = limit - v_11;
                            lab18: do {
                                // (, line 583
                                // not, line 583
                                lab19: do {
                                    // Boolean test is_defined, line 583
                                    if (!(B_is_defined))
                                    {
                                        break lab19;
                                    }
                                    break lab18;
                                } while (false);
                                // call Suffix_Noun_Step1a, line 583
                                if (!r_Suffix_Noun_Step1a())
                                {
                                    break lab18;
                                }
                                // (, line 583
                                // or, line 585
                                lab20: do {
                                    v_13 = limit - cursor;
                                    lab21: do {
                                        // call Suffix_Noun_Step2a, line 584
                                        if (!r_Suffix_Noun_Step2a())
                                        {
                                            break lab21;
                                        }
                                        break lab20;
                                    } while (false);
                                    cursor = limit - v_13;
                                    lab22: do {
                                        // call Suffix_Noun_Step2b, line 585
                                        if (!r_Suffix_Noun_Step2b())
                                        {
                                            break lab22;
                                        }
                                        break lab20;
                                    } while (false);
                                    cursor = limit - v_13;
                                    lab23: do {
                                        // call Suffix_Noun_Step2c1, line 586
                                        if (!r_Suffix_Noun_Step2c1())
                                        {
                                            break lab23;
                                        }
                                        break lab20;
                                    } while (false);
                                    cursor = limit - v_13;
                                    // next, line 587
                                    if (cursor <= limit_backward)
                                    {
                                        break lab18;
                                    }
                                    cursor--;
                                } while (false);
                                break lab16;
                            } while (false);
                            cursor = limit - v_11;
                            lab24: do {
                                // (, line 588
                                // call Suffix_Noun_Step1b, line 588
                                if (!r_Suffix_Noun_Step1b())
                                {
                                    break lab24;
                                }
                                // (, line 588
                                // or, line 590
                                lab25: do {
                                    v_14 = limit - cursor;
                                    lab26: do {
                                        // call Suffix_Noun_Step2a, line 589
                                        if (!r_Suffix_Noun_Step2a())
                                        {
                                            break lab26;
                                        }
                                        break lab25;
                                    } while (false);
                                    cursor = limit - v_14;
                                    lab27: do {
                                        // call Suffix_Noun_Step2b, line 590
                                        if (!r_Suffix_Noun_Step2b())
                                        {
                                            break lab27;
                                        }
                                        break lab25;
                                    } while (false);
                                    cursor = limit - v_14;
                                    // call Suffix_Noun_Step2c1, line 591
                                    if (!r_Suffix_Noun_Step2c1())
                                    {
                                        break lab24;
                                    }
                                } while (false);
                                break lab16;
                            } while (false);
                            cursor = limit - v_11;
                            lab28: do {
                                // (, line 592
                                // not, line 592
                                lab29: do {
                                    // Boolean test is_defined, line 592
                                    if (!(B_is_defined))
                                    {
                                        break lab29;
                                    }
                                    break lab28;
                                } while (false);
                                // call Suffix_Noun_Step2a, line 592
                                if (!r_Suffix_Noun_Step2a())
                                {
                                    break lab28;
                                }
                                break lab16;
                            } while (false);
                            cursor = limit - v_11;
                            // (, line 593
                            // call Suffix_Noun_Step2b, line 593
                            if (!r_Suffix_Noun_Step2b())
                            {
                                cursor = limit - v_10;
                                break lab15;
                            }
                        } while (false);
                    } while (false);
                    // call Suffix_Noun_Step3, line 595
                    if (!r_Suffix_Noun_Step3())
                    {
                        break lab14;
                    }
                    break lab4;
                } while (false);
                cursor = limit - v_5;
                // call Suffix_All_alef_maqsura, line 601
                if (!r_Suffix_All_alef_maqsura())
                {
                    break lab3;
                }
            } while (false);
        } while (false);
        cursor = limit - v_4;
        cursor = limit_backward;        // do, line 606
        v_16 = cursor;
        lab30: do {
            // (, line 606
            // try, line 607
            v_17 = cursor;
            lab31: do {
                // call Prefix_Step1, line 607
                if (!r_Prefix_Step1())
                {
                    cursor = v_17;
                    break lab31;
                }
            } while (false);
            // try, line 608
            v_18 = cursor;
            lab32: do {
                // (, line 608
                // or, line 608
                lab33: do {
                    v_19 = cursor;
                    lab34: do {
                        // call Prefix_Step2a, line 608
                        if (!r_Prefix_Step2a())
                        {
                            break lab34;
                        }
                        break lab33;
                    } while (false);
                    cursor = v_19;
                    // call Prefix_Step2b, line 608
                    if (!r_Prefix_Step2b())
                    {
                        cursor = v_18;
                        break lab32;
                    }
                } while (false);
            } while (false);
            // (, line 609
            // or, line 610
            lab35: do {
                v_20 = cursor;
                lab36: do {
                    // call Prefix_Step3a_Noun, line 609
                    if (!r_Prefix_Step3a_Noun())
                    {
                        break lab36;
                    }
                    break lab35;
                } while (false);
                cursor = v_20;
                lab37: do {
                    // (, line 610
                    // Boolean test is_noun, line 610
                    if (!(B_is_noun))
                    {
                        break lab37;
                    }
                    // call Prefix_Step3b_Noun, line 610
                    if (!r_Prefix_Step3b_Noun())
                    {
                        break lab37;
                    }
                    break lab35;
                } while (false);
                cursor = v_20;
                // (, line 611
                // Boolean test is_verb, line 611
                if (!(B_is_verb))
                {
                    break lab30;
                }
                // try, line 611
                v_21 = cursor;
                lab38: do {
                    // call Prefix_Step3_Verb, line 611
                    if (!r_Prefix_Step3_Verb())
                    {
                        cursor = v_21;
                        break lab38;
                    }
                } while (false);
                // call Prefix_Step4_Verb, line 611
                if (!r_Prefix_Step4_Verb())
                {
                    break lab30;
                }
            } while (false);
        } while (false);
        cursor = v_16;
        // do, line 616
        v_22 = cursor;
        lab39: do {
            // call Normalize_post, line 616
            if (!r_Normalize_post())
            {
                break lab39;
            }
        } while (false);
        cursor = v_22;
        return true;
    }

    public boolean equals( Object o ) {
        return o instanceof arabicStemmer;
    }

    public int hashCode() {
        return arabicStemmer.class.getName().hashCode();
    }



}

