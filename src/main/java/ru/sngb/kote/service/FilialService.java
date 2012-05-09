package ru.sngb.kote.service;

import ru.sngb.kote.domain.Filial;

import java.util.Collection;

/**
 * Filial serveice layer interface.
 * <p/>
 * Date: 09.05.12
 *
 * @author Tsykin V.A. (aka nektoDev), ts.slawa@gmail.com
 * @version 0.1
 */
public interface FilialService {
    void addFilial(Filial filial);

    void deleteFilial(Filial filial);

    void updateFilial(Filial filial);

    Collection<Filial> getAllFilials();

    Filial getFilialById(Integer id);
}
