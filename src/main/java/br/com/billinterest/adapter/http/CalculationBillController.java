package br.com.billinterest.adapter.http;

import br.com.billinterest.adapter.http.dto.CalculationBillRequest;
import br.com.billinterest.adapter.http.dto.CalculationBillResponse;
import br.com.billinterest.adapter.http.mapper.CalculationBillMapper;
import br.com.billinterest.core.port.in.CalculateBillPort;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/boleto")
public class CalculationBillController {

    private final CalculateBillPort calculateBillPort;
    private final CalculationBillMapper mapper;

    public CalculationBillController(CalculateBillPort calculateBillPort, CalculationBillMapper mapper) {
        this.calculateBillPort = calculateBillPort;
        this.mapper = mapper;
    }

    @PostMapping("/calculo")
    @Operation(summary = "Calculate bill interest")
    public ResponseEntity<CalculationBillResponse> calculateBill(@Valid @RequestBody CalculationBillRequest billRequest) {
        var calculatedBill = calculateBillPort.execute(billRequest.getCode(), billRequest.getPayDay());
        return ResponseEntity.ok(mapper.toDTO(calculatedBill));
    }
}
