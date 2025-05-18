package com.corhuila.app_explora_neiva.IService;

import com.corhuila.app_explora_neiva.Entity.Factura;

public interface IFacturaService extends IBaseService<Factura> {

    String generarNumeroFactura();
}
