package com.csi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailModel {

    private String toEmail;

    private String ccEmail;

    private String emailSubject;

    private String emailBody;

    private String attachment;


}
