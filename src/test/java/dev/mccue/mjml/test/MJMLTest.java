package dev.mccue.mjml.test;

import dev.mccue.mjml.MJML;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MJMLTest {
    @Test
    public void testExampleCode() {
        var mjml = MJML.of("""
                <mjml>
                  <mj-body>
                    <mj-section>
                      <mj-column>
                
                        <mj-image width="100px" src="/assets/img/logo-small.png"></mj-image>
                
                        <mj-divider border-color="#F45E43"></mj-divider>
                
                        <mj-text font-size="20px" color="#F45E43" font-family="helvetica">Hello World</mj-text>
                
                      </mj-column>
                    </mj-section>
                  </mj-body>
                </mjml>
                """);

        assertEquals(
                mjml.toHtmlString().strip(),
                """
                        <!doctype html>
                        <html lang="und" dir="auto" xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office">
                          <head>
                            <title></title>
                            <!--[if !mso]><!-->
                            <meta http-equiv="X-UA-Compatible" content="IE=edge">
                            <!--<![endif]-->
                            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                            <meta name="viewport" content="width=device-width, initial-scale=1">
                            <style type="text/css">
                              #outlook a { padding:0; }
                              body { margin:0;padding:0;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%; }
                              table, td { border-collapse:collapse;mso-table-lspace:0pt;mso-table-rspace:0pt; }
                              img { border:0;height:auto;line-height:100%; outline:none;text-decoration:none;-ms-interpolation-mode:bicubic; }
                              p { display:block;margin:13px 0; }
                            </style>
                            <!--[if mso]>
                            <noscript>
                            <xml>
                            <o:OfficeDocumentSettings>
                              <o:AllowPNG/>
                              <o:PixelsPerInch>96</o:PixelsPerInch>
                            </o:OfficeDocumentSettings>
                            </xml>
                            </noscript>
                            <![endif]-->
                            <!--[if lte mso 11]>
                            <style type="text/css">
                              .mj-outlook-group-fix { width:100% !important; }
                            </style>
                            <![endif]-->
                           \s
                           \s
                            <style type="text/css">
                              @media only screen and (min-width:480px) {
                                .mj-column-per-100 { width:100% !important; max-width: 100%; }
                              }
                            </style>
                            <style media="screen and (min-width:480px)">
                              .moz-text-html .mj-column-per-100 { width:100% !important; max-width: 100%; }
                            </style>
                           \s
                           \s
                         \s
                           \s
                            <style type="text/css">
                        
                            @media only screen and (max-width:479px) {
                              table.mj-full-width-mobile { width: 100% !important; }
                              td.mj-full-width-mobile { width: auto !important; }
                            }
                         \s
                            </style>
                           \s
                           \s
                          </head>
                          <body style="word-spacing:normal;">
                           \s
                           \s
                              <div
                                 style="" lang="und" dir="auto"
                              >
                               \s
                             \s
                              <!--[if mso | IE]><table align="center" border="0" cellpadding="0" cellspacing="0" class="" role="presentation" style="width:600px;" width="600" ><tr><td style="line-height:0px;font-size:0px;mso-line-height-rule:exactly;"><![endif]-->
                           \s
                             \s
                              <div  style="margin:0px auto;max-width:600px;">
                               \s
                                <table
                                   align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="width:100%;"
                                >
                                  <tbody>
                                    <tr>
                                      <td
                                         style="direction:ltr;font-size:0px;padding:20px 0;text-align:center;"
                                      >
                                        <!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><tr><td class="" style="vertical-align:top;width:600px;" ><![endif]-->
                                   \s
                              <div
                                 class="mj-column-per-100 mj-outlook-group-fix" style="font-size:0px;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:100%;"
                              >
                               \s
                              <table
                                 border="0" cellpadding="0" cellspacing="0" role="presentation" style="vertical-align:top;" width="100%"
                              >
                                <tbody>
                                 \s
                                      <tr>
                                        <td
                                           align="center" style="font-size:0px;padding:10px 25px;word-break:break-word;"
                                        >
                                         \s
                              <table
                                 border="0" cellpadding="0" cellspacing="0" role="presentation" style="border-collapse:collapse;border-spacing:0px;"
                              >
                                <tbody>
                                  <tr>
                                    <td  style="width:100px;">
                                     \s
                              <img
                                 alt="" src="/assets/img/logo-small.png" style="border:0;display:block;outline:none;text-decoration:none;height:auto;width:100%;font-size:13px;" width="100" height="auto"
                              />
                           \s
                                    </td>
                                  </tr>
                                </tbody>
                              </table>
                           \s
                                        </td>
                                      </tr>
                                   \s
                                      <tr>
                                        <td
                                           align="center" style="font-size:0px;padding:10px 25px;word-break:break-word;"
                                        >
                                         \s
                              <p
                                 style="border-top:solid 4px #F45E43;font-size:1px;margin:0px auto;width:100%;"
                              >
                              </p>
                             \s
                              <!--[if mso | IE]><table align="center" border="0" cellpadding="0" cellspacing="0" style="border-top:solid 4px #F45E43;font-size:1px;margin:0px auto;width:550px;" role="presentation" width="550px" ><tr><td style="height:0;line-height:0;"> &nbsp;
                        </td></tr></table><![endif]-->
                           \s
                           \s
                                        </td>
                                      </tr>
                                   \s
                                      <tr>
                                        <td
                                           align="left" style="font-size:0px;padding:10px 25px;word-break:break-word;"
                                        >
                                         \s
                              <div
                                 style="font-family:helvetica;font-size:20px;line-height:1;text-align:left;color:#F45E43;"
                              >Hello World</div>
                           \s
                                        </td>
                                      </tr>
                                   \s
                                </tbody>
                              </table>
                           \s
                              </div>
                           \s
                                  <!--[if mso | IE]></td></tr></table><![endif]-->
                                      </td>
                                    </tr>
                                  </tbody>
                                </table>
                               \s
                              </div>
                           \s
                             \s
                              <!--[if mso | IE]></td></tr></table><![endif]-->
                           \s
                           \s
                              </div>
                           \s
                          </body>
                        </html>""".strip()
        );
    }

    @Test
    public void withComments() {
        var mjml = MJML.of("""
                <mjml>
                  <mj-body>
                    <mj-section>
                      <mj-column>
                
                        <!-- EXAMPLE -->
                        <mj-image width="100px" src="/assets/img/logo-small.png"></mj-image>
                
                        <mj-divider border-color="#F45E43"></mj-divider>
                
                        <mj-text font-size="20px" color="#F45E43" font-family="helvetica">Hello World</mj-text>
                
                      </mj-column>
                    </mj-section>
                  </mj-body>
                </mjml>
                """);

        var with = mjml.toHtmlString(options -> options.keepComments(true));
        var without = mjml.toHtmlString(options -> options.keepComments(false));

        assertTrue(with.contains("EXAMPLE"), "keep comments");
        assertFalse(without.contains("EXAMPLE"), "drop comments");
    }
}
