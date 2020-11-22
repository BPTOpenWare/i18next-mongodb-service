package com.bptopenware.messages.i18nextrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface I18NextRepository extends JpaRepository<I18NextDTO, Integer> {

	public I18NextDTO findBySysidAndAppidAndCompidAndLanguageAndNamespace(String sysid, String appid, String compid, String language, String namespace);

}
