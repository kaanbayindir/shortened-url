package com.tapu.interview.service.impl;

import com.google.common.hash.Hashing;
import com.tapu.interview.model.Url;
import com.tapu.interview.model.UrlDto;
import com.tapu.interview.repositoy.UrlRepository;
import com.tapu.interview.service.UrlService;
import com.tapu.interview.util.UrlUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import static com.tapu.interview.util.UrlUtils.encodeUrl;

@Component
public class UrlServiceImpl implements UrlService {

    private UrlRepository urlRepository;

    @Autowired
    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public Url generateShortLink(UrlDto urlDto) {

        if (StringUtils.isNotEmpty(urlDto.getUrl())) {

            String encodedUrl = UrlUtils.encodeUrl(urlDto.getUrl());
            Url urlToPersist = new Url();
            urlToPersist.setCreationDate(LocalDateTime.now());
            urlToPersist.setOriginalUrl(urlDto.getUrl());
            urlToPersist.setShortLink(encodedUrl);
            urlToPersist.setExpirationDate(UrlUtils.getExpirationDate(urlDto.getExpirationDate(), urlToPersist.getCreationDate()));
            urlToPersist.setUser(urlDto.getUser());
            Url urlToRet = persistShortLink(urlToPersist);

            if (urlToRet != null) {
                return urlToRet;
            }
            return null;
        }
        return null;
    }


    /**
     * commentleri yaz
     * util lere taşı
     * constantlara taşı
     * enumlara atabileceklerini at
     *
     * @param url
     * @return
     */


    @Override
    public Url persistShortLink(Url url) {
        Url found = urlRepository.findByShortLink(url.getShortLink());
        if (null == found) {
            Url urlToRet = urlRepository.save(url);
            return urlToRet;
        } else {
            return found;
        }
    }

    @Override
    public Url getEncodedUrl(String url) {
        Url urlToRet = urlRepository.findByShortLink(url);
        return urlToRet;

    }

    @Override
    public void deleteShortLink(Url url) {
        urlRepository.delete(url);
    }
}
