package Exam.fishing.repository;

import Exam.fishing.entity.site.Site;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SiteRepository implements Repository<Site> {
    private Collection<Site> sites;

    public SiteRepository() {
        this.sites = new ArrayList<>();
    }

    @Override
    public Collection<Site> getCollection() {
        return Collections.unmodifiableCollection(sites);
    }

    @Override
    public void add(Site entity) {
        this.sites.add(entity);
    }

    @Override
    public boolean remove(Site entity) {
        return this.sites.remove(entity);
    }

    @Override
    public Site byName(String name) {
        for (Site site : this.sites) {
            if (site.getName().equals(name)){
                return site;
            }
        }
        return null;
    }
}
