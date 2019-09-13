package pl.coderslab.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JsonResponse {
   private int status;
   private String message;
}
